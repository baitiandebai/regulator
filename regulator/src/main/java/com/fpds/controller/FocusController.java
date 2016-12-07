package com.fpds.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.fpds.entity.QualityFocus;
import com.fpds.service.inter.FocusServiceInter;
import com.fpds.util.Contants;
import com.fpds.util.UUIDGenerator;

/**
 * 质量热点的相关接口
 * @author LX
 *
 */
@Controller
@RequestMapping(value="/focus",
	produces="application/json;charset=utf-8")
public class FocusController {

	@Autowired
	private FocusServiceInter focusService;
	
	/**
	 * 根据Id查询新闻
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/get/{id}",
			method=RequestMethod.GET)
	@ResponseBody
	public String getNewById(@PathVariable("id")String id){
		
		if(StringUtils.isBlank(id)){
			return Contants.PARAM_NULL;
		}
		QualityFocus qualityFocus = focusService.getNewById(id);
		return JSONObject.toJSONString(qualityFocus);
	}
	/**
	 * 根据新闻分类获得新闻
	 * @param current 页码
	 * @param size 每页条数
	 * @param type 分类
	 * @return Json: {total: 8, data: [{},{}..]}
	 */
	@RequestMapping(value="/get/type",
			method=RequestMethod.GET)
	@ResponseBody
	public String getNewByType(@RequestParam("current")Integer current,
			@RequestParam("size")Integer size,@RequestParam("type")String type){
		
		if(current == null || size == null || StringUtils.isBlank(type)){
			return Contants.PARAM_NULL;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		List<QualityFocus> qualityFocusList = focusService.getNewByType(current, size, type);
		map.put("total",qualityFocusList.size());
		map.put("data",JSONObject.toJSONString(qualityFocusList));
		return JSONObject.toJSONString(map);
	}
	
	/**
	 * 根据流行程度查询新闻列表
	 * @param current 页码
	 * @param size 每页条数
	 * @param category 种类
	 * @return Json: {total: 8, data: [{},{}..]}
	 */
	@RequestMapping(value="/get/category",
			method=RequestMethod.GET)
	@ResponseBody
	public String getNewByCategory(@RequestParam("current")Integer current,
			@RequestParam("size")Integer size,@RequestParam("category")String category){
		if(current == null || size == null || StringUtils.isBlank(category)){
			return Contants.PARAM_NULL;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		List<QualityFocus> qualityFocusList = focusService.getNewByCategory(current, size, category);
		map.put("total",qualityFocusList.size());
		map.put("data",JSONObject.toJSONString(qualityFocusList));
		return JSONObject.toJSONString(map);
	}
	
	/**
	 * 根据关键字搜索新闻列表
	 * @param current 页码
	 * @param size 每页条数
	 * @param keyword 关键字,暂定为新闻标题
	 * @return Json: {total: 8, data: [{},{}..]}
	 */
	@RequestMapping(value="/get/key",
			method=RequestMethod.GET)
	@ResponseBody
	public String getNewByKeyword(@RequestParam("current")Integer current,
			@RequestParam("size")Integer size,@RequestParam("keyword")String keyword){
		if(current == null || size == null){
			return Contants.PARAM_NULL;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		List<QualityFocus> qualityFocusList = focusService.getNewByKeyword(current, size, keyword);
		map.put("total",qualityFocusList.size());
		map.put("data",JSONObject.toJSONString(qualityFocusList));
		return JSONObject.toJSONString(map);
	}
	/**
	 * 保存新闻
	 * @param json
	 * @return
	 */
	@RequestMapping(value="/save",
			method=RequestMethod.POST)
	@ResponseBody
	public String saveNew(@RequestBody String json){
		
		QualityFocus qualityFocus = JSONObject.parseObject(json, QualityFocus.class);
		qualityFocus.check();
		qualityFocus.setId(UUIDGenerator.getUUID());
		String result = focusService.saveNew(qualityFocus);
		return result;
	}
	
	/**
	 * 更新数据
	 * @param json
	 * @return
	 */
	@RequestMapping(value="/update",
			method=RequestMethod.PUT)
	@ResponseBody
	public String updateNew(@RequestBody String json){
		if(StringUtils.isBlank(json)){
			return Contants.PARAM_NULL;
		}
		QualityFocus qualityFocus = JSONObject.parseObject(json, QualityFocus.class);
		String result = focusService.updateNew(qualityFocus);
		return result;
	}
	
	/**
	 * 根据id删除新闻
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete/{id}",
			method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteNew(@PathVariable("id")String id){
		if(StringUtils.isBlank(id)){
			return Contants.PARAM_NULL;
		}
		String result = focusService.deleteNew(id);
		return result;
	}
}
