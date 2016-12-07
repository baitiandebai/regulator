package com.fpds.service.inter;

import java.util.List;


import com.fpds.entity.QualityExposure;

public interface ExposureServiceInter {
	public QualityExposure getExposureById(String id);

	public List<QualityExposure> getExposureByProductClass(Integer current, Integer size, String productClass1,
			String productClass2);

	public List<QualityExposure> getExposureByKeyword(Integer current, Integer size, String keyword);

	public String saveExposure(QualityExposure qualityExposure);

	public String deleteExposure(String id);

	public String updateExposure(QualityExposure qualityExposure);

	public String saveExposureList(List<QualityExposure> qualityExposuresList);

	public Integer getExposureByProductClassTotal(String productClass1,String productClass2);

	public Integer getExposureByKeywordTotal(String keyword);

}
