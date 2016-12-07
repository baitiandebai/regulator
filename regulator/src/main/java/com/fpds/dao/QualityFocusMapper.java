package com.fpds.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fpds.entity.QualityFocus;

public interface QualityFocusMapper {
	public Integer deleteNew(String id);

    public int saveNew(QualityFocus qualityFocus);

    public List<QualityFocus> getNewByType(
    		@Param("total")Integer total, @Param("size")Integer size, @Param("type")String type);
    
    public List<QualityFocus> getNewByCategory(
    		@Param("total")Integer total, @Param("size")Integer size, @Param("category")String category);
    
    public List<QualityFocus> getNewByKeyword(
    		@Param("total")Integer total, @Param("size")Integer size, @Param("keyword")String keyword);
    
    public QualityFocus getNewById(String id);

    public Integer updateNew(QualityFocus record);
}