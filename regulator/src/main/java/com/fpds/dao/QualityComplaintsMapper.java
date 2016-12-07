package com.fpds.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fpds.entity.QualityComplaints;

public interface QualityComplaintsMapper {
	public Integer deleteComplaints(String id);

    public int saveComplaints(QualityComplaints qualityComplaints);

    public List<QualityComplaints> getComplaintsByType(
    		@Param("total")Integer total, @Param("size")Integer size, @Param("type")String type);
    
    public List<QualityComplaints> getComplaintsByCategory(
    		@Param("total")Integer total, @Param("size")Integer size, @Param("category")String category);
    
    public List<QualityComplaints> getComplaintsByKeyword(
    		@Param("total")Integer total, @Param("size")Integer size, @Param("keyword")String keyword);
    
    public QualityComplaints getComplaintsById(String id);

    public Integer updateComplaints(QualityComplaints qualityComplaints);
    
    public Integer getComplaintsByTypeTotal(@Param("type")String type);
    
    public Integer getComplaintsByCategoryTotal(@Param("category")String category);
    
    public Integer getComplaintsByKeywordTotal(@Param("keyword")String keyword);
    
}