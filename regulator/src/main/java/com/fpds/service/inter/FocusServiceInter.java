package com.fpds.service.inter;

import java.util.List;

import com.fpds.entity.QualityFocus;

public interface FocusServiceInter {

	public QualityFocus getNewById(String id);
	
	public List<QualityFocus> getNewByType(Integer current,Integer size,String type);
	
	public List<QualityFocus> getNewByCategory(Integer current,Integer size,String category);
	
	public List<QualityFocus> getNewByKeyword(Integer current,Integer size,String keyword);
	
	public String saveNew(QualityFocus qualityFocus);
	
	public String deleteNew(String id);
	
	public String updateNew(QualityFocus qualityFocus);
}
