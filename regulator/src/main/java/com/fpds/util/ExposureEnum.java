package com.fpds.util;

public enum ExposureEnum {

	NAME("CompanyName",1),LOCATION("Location",2),PRODUCTNAME("ProductName",3),
	BRAND("Brand",4),MODEL("Model",5),BATCH("Batch",6),
	RESULT("Result",7),REASON("Reason",8),ACCREDITATIONBODY("AccreditationBody",9);
//	PRODUCTCLASS1("ProductClass1",10),PRODUCTCLASS1Name("ProductClass1Name",11),
//	PRODUCTCLASS2("ProductClass2",12),PRODUCTCLASS2Name("ProductClass2Name",13);
	
	private String code;
	private Integer message;
	
	private ExposureEnum(String code,Integer message){
		this.code = code;
		this.message = message;
	}

	public static String getCode(Integer message){
		for(ExposureEnum exposureEnum : ExposureEnum.values()){
			if(exposureEnum.message.equals(message)){
				return exposureEnum.code;
			}
		}
		return null;
	}
	
}
