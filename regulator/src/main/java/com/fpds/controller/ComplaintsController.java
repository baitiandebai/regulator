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
import com.fpds.entity.QualityComplaints;
import com.fpds.service.inter.ComplaintsServiceInter;
import com.fpds.util.Contants;
import com.fpds.util.UUIDGenerator;

@RequestMapping(value="/complaints",
		produces="application/json;charset=utf-8")
@Controller
public class ComplaintsController {

	@Autowired
	private ComplaintsServiceInter complaintsService;
	
	@RequestMapping(value="get/{id}",
			method=RequestMethod.GET)
	@ResponseBody
	public String getComplaintsById(@PathVariable("id")String id){
		if(StringUtils.isBlank(id)){
			return Contants.PARAM_NULL;
		}
		QualityComplaints qualityComplaints = complaintsService.getComplaintsById(id);
		return JSONObject.toJSONString(qualityComplaints);
	}
	
	@RequestMapping(value="get/category",
			method=RequestMethod.GET)
	@ResponseBody
	public String getComplaintsByCategory(@RequestParam("current")Integer current,
			@RequestParam("size")Integer size,@RequestParam("category")String category){
		if(current == null || size == null || StringUtils.isBlank(category)){
			return Contants.PARAM_NULL;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		List<QualityComplaints> qualityComplaintsList = complaintsService.getComplaintsByCategory(current, size, category);
		map.put("total",qualityComplaintsList.size());
		map.put("data",JSONObject.toJSONString(qualityComplaintsList));
		return JSONObject.toJSONString(map);
	}
	
	@RequestMapping(value="get/type",
			method=RequestMethod.GET)
	@ResponseBody
	public String getComplaintsByType(@RequestParam("current")Integer current,
			@RequestParam("size")Integer size,@RequestParam("type")String type){
		if(current == null || size == null || StringUtils.isBlank(type)){
			return Contants.PARAM_NULL;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		List<QualityComplaints> qualityComplaintsList = complaintsService.getComplaintsByType(current, size, type);
		map.put("total",qualityComplaintsList.size());
		map.put("data",JSONObject.toJSONString(qualityComplaintsList));
		return JSONObject.toJSONString(map);
	}
	
	@RequestMapping(value="get/keyword",
			method=RequestMethod.GET)
	@ResponseBody
	public String getComplaintsByKeyword(@RequestParam("current")Integer current,
			@RequestParam("size")Integer size,@RequestParam("keyword")String keyword){
		if(current == null || size == null){
			return Contants.PARAM_NULL;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		List<QualityComplaints> qualityComplaintsList = complaintsService.getComplaintsByKeyword(current, size, keyword);
		map.put("total",qualityComplaintsList.size());
		map.put("data",JSONObject.toJSONString(qualityComplaintsList));
		return JSONObject.toJSONString(map);
	}
	
	@RequestMapping(value="save",
			method=RequestMethod.POST)
	@ResponseBody
	public String saveComplaints(@RequestBody String json){
		QualityComplaints qualityComplaints = JSONObject.parseObject(json, QualityComplaints.class);
		qualityComplaints.check();
		qualityComplaints.setId(UUIDGenerator.getUUID());
		String result = complaintsService.saveComplaints(qualityComplaints);
		return result;
	}
	
	@RequestMapping(value="update",
			method=RequestMethod.PUT)
	@ResponseBody
	public String updateComplaints(@RequestBody String json){
		if(StringUtils.isBlank(json)){
			return Contants.PARAM_NULL;
		}
		QualityComplaints qualityComplaints = JSONObject.parseObject(json, QualityComplaints.class);
		String result = complaintsService.updateComplaints(qualityComplaints);
		return result;
	}
	
	@RequestMapping(value="delete/{id}",
			method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteComplaints(@PathVariable("id")String id){
		if(StringUtils.isBlank(id)){
			return Contants.PARAM_NULL;
		}
		String result = complaintsService.deleteComplaints(id);
		return result;
	}
}
