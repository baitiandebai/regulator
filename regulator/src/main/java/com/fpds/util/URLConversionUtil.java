package com.fpds.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 统一编码、解码 --> 防止中文乱码问题出现
 * 
 * @author LX
 * @version 2016.12.9 新建
 */
public class URLConversionUtil {

	/**
	 * 将编码转为URL的编码格式
	 * 
	 * @param str
	 *            将要转换的字符串
	 * @return
	 */
	public static String encode(String str) {
		try {
			return URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 将URL编码转为普通编码
	 * 
	 * @param str
	 *            将要转换的字符串
	 * @return
	 */
	public static String decode(String str) {
		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

}
