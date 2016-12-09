package com.fpds.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.fpds.util.Contants;
import com.fpds.util.HTTPRequest;
import com.fpds.util.URLConversionUtil;

@Controller
@RequestMapping("login")
public class LoginController {

	@RequestMapping(value="/admin",
			method=RequestMethod.GET,
			produces="application/json;charset=utf-8")
	@ResponseBody
	public String login(@RequestParam("username")String username,
			@RequestParam("passwd")String passwd){
		
		if(StringUtils.isBlank(username) || StringUtils.isBlank(passwd)){
			return Contants.PARAM_NULL;
		}
		
		Map<Object,Object> object = new HashMap<>();
		object.put("username", username);
		object.put("password", passwd);
		String content = HTTPRequest.doPost(Contants.LOGIN_PATH,object);
		return URLConversionUtil.decode(content);
	}
}
