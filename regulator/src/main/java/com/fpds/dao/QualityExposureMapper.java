package com.fpds.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fpds.entity.QualityExposure;

public interface QualityExposureMapper {
	public Integer deleteExposure(String id);

    public int saveExposure(QualityExposure qualityExposure);

    public List<QualityExposure> getExposureByProductClass(
    		@Param("total")Integer total, @Param("size")Integer size, 
    		@Param("productClass1")String productClass1,@Param("productClass2")String productClass2);
    
    public List<QualityExposure> getExposureByKeyword(
    		@Param("total")Integer total, @Param("size")Integer size, @Param("keyword")String keyword);
    
    public QualityExposure getExposureById(String id);

    public Integer updateExposure(QualityExposure record);
    
    public Integer saveExposureList(List<QualityExposure> qualityExposuresList);

    public Integer getExposureByProductClassTotal(@Param("productClass1")String productClass1,
    		@Param("productClass2")String productClass2);
    
    public Integer getExposureByKeywordTotal(@Param("keyword")String keyword);
    
}