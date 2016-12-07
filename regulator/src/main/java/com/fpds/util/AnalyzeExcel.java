package com.fpds.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.fpds.entity.QualityExposure;

public class AnalyzeExcel {

	

	public static List<QualityExposure> readExcelContent(InputStream is) {
		
		POIFSFileSystem fs = new POIFSFileSystem();
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet;
		HSSFRow row;
		
		List<QualityExposure> exposureList = new ArrayList<QualityExposure>();
		try {
			fs = new POIFSFileSystem(is);
			wb = new HSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		for (int i = 2; i <= rowNum; i++) {
			row = sheet.getRow(i);
			HSSFCell cell = row.getCell(7);
			if(StringUtils.equals(cell.getStringCellValue(),Contants.EXCEL_CELL)){
				QualityExposure qualityExposure = new QualityExposure();
				qualityExposure.setId(UUIDGenerator.getUUID());
				for(int j = 1 ; j < colNum; j++){
					HSSFCell jcell = row.getCell(j);
					String key = ExposureEnum.getCode(j);
					try {
						InvokeExposure.method(qualityExposure, key,jcell.getStringCellValue());
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
				exposureList.add(qualityExposure);
			}
		}
		return exposureList;
	}
}
