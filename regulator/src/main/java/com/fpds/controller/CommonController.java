package com.fpds.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.fpds.util.Contants;
import com.fpds.util.CreateImageUtil;

/**
 * 公共的接口类
 * 
 * @author LX
 * 
 */
@RequestMapping("/common")
@Controller
public class CommonController {

	@RequestMapping(value="/upload/image",
			method={RequestMethod.POST,RequestMethod.OPTIONS})
	@ResponseBody
	public String uploadImage(@RequestBody MultipartFile file,HttpServletRequest request){
		
		String path = request.getSession().getServletContext().getRealPath("");
		String fileName = file.getOriginalFilename();
		String[] name = fileName.split("\\.");
		String nameLocal = System.currentTimeMillis() + "."+ name[name.length -1];
		File localFile = new File(path + Contants.SAVE_PATH_IMAGE);
		if(!localFile.exists()){
			localFile.mkdirs();
		}
		File imageFile = new File(path + Contants.SAVE_PATH_IMAGE + nameLocal);
		imageFile.mkdirs();
		
		CommonsMultipartFile cf= (CommonsMultipartFile)file; 
		try {
			cf.transferTo(imageFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String path2 = "http://" + request.getServerName()  + ":"   
						+ request.getServerPort()         
						+ request.getContextPath(); 
  
		return path2 + Contants.SAVE_PATH_IMAGE + nameLocal;
	}
	@RequestMapping(value="/verification/image",
			method=RequestMethod.GET)
	@ResponseBody
	public String uploadImage(HttpServletRequest request){
		String path = request.getSession().getServletContext().getRealPath("");
		
		Integer num = (int) (Math.random()*10000);
        while(num < 1000){
        	num = (int) (Math.random()*10000);
        }
		
		CreateImageUtil.create(path + Contants.VALID_IMAGE,num.toString());
		
		StringBuilder sb = new StringBuilder();
		sb.append("http://" + request.getServerName());
		sb.append(":" + request.getServerPort());
		sb.append(request.getContextPath() + Contants.VALID_IMAGE);
		
		Map<String,String> map = new HashMap<>();
		map.put("path", sb.toString());
		map.put("code", num.toString());
		return JSONObject.toJSONString(map);
	}
}
