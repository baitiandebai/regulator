package com.fpds.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.fpds.entity.QualityExposure;

public class InvokeExposure {

	public static void method(QualityExposure qualityExposure,String key,String value) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		@SuppressWarnings("rawtypes")
		Class clazz = qualityExposure.getClass();
		String methodName = "set" + key;
		@SuppressWarnings("unchecked")
		Method m1 = clazz.getDeclaredMethod(methodName, String.class);
		m1.invoke(qualityExposure, value);
	}
	
//	public static void method(QualityExposure qualityExposure,String key,double value) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
//		@SuppressWarnings("rawtypes")
//		Class clazz = qualityExposure.getClass();
//		String methodName = "set" + key;
//		@SuppressWarnings("unchecked")
//		Method m1 = clazz.getDeclaredMethod(methodName, Integer.class);
//		m1.invoke(qualityExposure, (int)value);
//	}
	
	public static boolean isInteger(String value){
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
