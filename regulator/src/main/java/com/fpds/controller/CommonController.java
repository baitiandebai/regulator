package com.fpds.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fpds.util.Contants;

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
}
