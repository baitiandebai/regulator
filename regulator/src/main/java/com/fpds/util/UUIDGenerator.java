package com.fpds.util;

import java.util.UUID;

public class UUIDGenerator {

	private UUIDGenerator(){}
	public static String getUUID(){
		StringBuffer sb = new StringBuffer();
		String uuid = UUID.randomUUID().toString();
		sb.append(uuid.substring(0,8));
		sb.append(uuid.substring(9,13));
		sb.append(uuid.substring(14,18));
		sb.append(uuid.substring(19,23));
		sb.append(uuid.substring(24));
		return sb.toString();
	}
}
