package com.fpds.service.inter;

import java.util.List;

import com.fpds.entity.QualityComplaints;

public interface ComplaintsServiceInter {

	public QualityComplaints getComplaintsById(String id);

	public List<QualityComplaints> getComplaintsByType(Integer current, Integer size, String type);

	public List<QualityComplaints> getComplaintsByCategory(Integer current, Integer size, String category);

	public List<QualityComplaints> getComplaintsByKeyword(Integer current, Integer size, String keyword);

	public String saveComplaints(QualityComplaints qualityComplaints);

	public String deleteComplaints(String id);

	public String updateComplaints(QualityComplaints qualityComplaints);
	
	public Integer getComplaintsByTypeTotal(String type);
	    
	public Integer getComplaintsByCategoryTotal(String category);
	    
	public Integer getComplaintsByKeywordTotal(String keyword);
	    
}
