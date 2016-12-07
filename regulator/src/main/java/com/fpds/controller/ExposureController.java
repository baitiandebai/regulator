package com.fpds.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.fpds.entity.QualityExposure;
import com.fpds.service.inter.ExposureServiceInter;
import com.fpds.util.AnalyzeExcel;
import com.fpds.util.Contants;

/**
 * 质量曝光
 * @author LX
 *
 */
@Controller
@RequestMapping(value="/exposure",
	produces="application/json;charset=utf-8")
public class ExposureController {
	
	private Logger log = Logger.getLogger(ExposureController.class);
	
	@Autowired
	private ExposureServiceInter exposureService;
	
	/**
	 * 根据Id查询新闻
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/get/{id}",
			method=RequestMethod.GET)
	@ResponseBody
	public String getxposureById(@PathVariable("id")String id){
		
		if(StringUtils.isBlank(id)){
			return Contants.PARAM_NULL;
		}
		QualityExposure qualityExposure = exposureService.getExposureById(id);
		return JSONObject.toJSONString(qualityExposure);
	}
	/**
	 * 根据所属行业和细分行业查询曝光列表
	 * @param current 页码
	 * @param size 每页条数
	 * @param productClass1  所属行业编号
	 * @param productClass2  细分行业编号
	 * @return Json: {total: 8, data: [{},{}..]}
	 */
	@RequestMapping(value="/get/type",
			method=RequestMethod.GET)
	@ResponseBody
	public String getExposureByType(@RequestParam("current")Integer current,
			@RequestParam("size")Integer size,@RequestParam("productClass1")String productClass1,
			@RequestParam("productClass2")String productClass2){
		
		if(current == null || size == null || 
				StringUtils.isBlank(productClass1) || StringUtils.isBlank(productClass2)){
			return Contants.PARAM_NULL;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		List<QualityExposure> qualityExposureList = exposureService.getExposureByProductClass(current, size, productClass1,productClass2);
		Integer total = exposureService.getExposureByProductClassTotal(productClass1, productClass2);
		map.put("total",total);
		map.put("data",JSONObject.toJSONString(qualityExposureList));
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
	public String getExposureByKeyword(@RequestParam("current")Integer current,
			@RequestParam("size")Integer size,@RequestParam("keyword")String keyword){
		if(current == null || size == null){
			return Contants.PARAM_NULL;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		List<QualityExposure> qualityExposuresList = exposureService.getExposureByKeyword(current, size, keyword);
		Integer total = exposureService.getExposureByKeywordTotal(keyword);
		map.put("total",total);
		map.put("data",JSONObject.toJSONString(qualityExposuresList));
		return JSONObject.toJSONString(map);
	}
//	/**
//	 * 保存新闻
//	 * @param json
//	 * @return
//	 */
//	@RequestMapping(value="/save",
//			method=RequestMethod.POST)
//	@ResponseBody
//	public String saveExposure(@RequestBody String json){
//		
//		QualityExposure qualityExposure = JSONObject.parseObject(json, QualityExposure.class);
//		qualityExposure.check();
//		qualityExposure.setId(UUIDGenerator.getUUID());
//		String result = exposureService.saveExposure(qualityExposure);
//		return result;
//	}
	
	/**
	 * 更新数据
	 * @param json
	 * @return
	 */
	@RequestMapping(value="/update",
			method=RequestMethod.PUT)
	@ResponseBody
	public String updateExposure(@RequestBody String json){
		if(StringUtils.isBlank(json)){
			return Contants.PARAM_NULL;
		}
		QualityExposure qualityExposure = JSONObject.parseObject(json, QualityExposure.class);
		String result = exposureService.updateExposure(qualityExposure);
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
	public String deleteExposure(@PathVariable("id")String id){
		if(StringUtils.isBlank(id)){
			return Contants.PARAM_NULL;
		}
		String result = exposureService.deleteExposure(id);
		return result;
	}
	/**
	 * 上传Excel，返回数据。
	 */
	@RequestMapping(value="upload/excel",
			method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String uploadExcel(@RequestParam("file")  MultipartFile  file){
		List<QualityExposure> qualityExposuresList = new ArrayList<QualityExposure>();
		try {
			InputStream is = file.getInputStream();
			qualityExposuresList = AnalyzeExcel.readExcelContent(is);
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return Contants.ANALYZE_EXCELL;
		}
		
		return JSONObject.toJSONString(qualityExposuresList);
		
	}
	/**
	 * 保存Excel中的数据
	 */
	@RequestMapping(value="save/excel",
			method=RequestMethod.POST)
	@ResponseBody
	public String saveExcelData(@RequestBody String json){
		
		if(StringUtils.isBlank(json)){
			return Contants.PARAM_NULL;
		}
		List<QualityExposure> qualityExposuresList = JSONObject.parseArray(json, QualityExposure.class);
		String result = exposureService.saveExposureList(qualityExposuresList);
		return result;
	}
}
