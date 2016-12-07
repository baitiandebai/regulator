package com.fpds.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpds.dao.QualityComplaintsMapper;
import com.fpds.entity.QualityComplaints;
import com.fpds.service.inter.ComplaintsServiceInter;
import com.fpds.util.Contants;

@Service
public class ComplaintsServiceImpl implements ComplaintsServiceInter{

	private static Logger log = Logger.getLogger(ComplaintsServiceImpl.class);

	@Autowired
	private QualityComplaintsMapper complaintsDao;
	
	public QualityComplaints getComplaintsById(String id) {
		try {
			QualityComplaints qualityComplaints = complaintsDao.getComplaintsById(id);
			return qualityComplaints;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

	public List<QualityComplaints> getComplaintsByType(Integer current, Integer size, String type) {
		try {
			List<QualityComplaints> qualityComplaintsList = complaintsDao.getComplaintsByType(current*size, size, type);
			return qualityComplaintsList;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

	public List<QualityComplaints> getComplaintsByCategory(Integer current, Integer size, String category) {
		try {
			List<QualityComplaints> qualityComplaintsList = complaintsDao.getComplaintsByCategory(current*size, size, category);
			return qualityComplaintsList;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

	public List<QualityComplaints> getComplaintsByKeyword(Integer current, Integer size, String keyword) {
		try {
			List<QualityComplaints> qualityComplaintsList = complaintsDao.getComplaintsByKeyword(current*size, size, keyword);
			return qualityComplaintsList;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

	public String saveComplaints(QualityComplaints qualityComplaints) {
		String result;
		try {
			result = complaintsDao.saveComplaints(qualityComplaints) + "";
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			result = Contants.SAVE_ERROR;
		}
		return result;
	}

	public String deleteComplaints(String id) {
		String result = null;
		try {
			result = complaintsDao.deleteComplaints(id).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			result = Contants.DELETE_ERROR;
		}
		return result;
	}

	public String updateComplaints(QualityComplaints qualityComplaints) {
		String result = null;
		try {
			result = complaintsDao.updateComplaints(qualityComplaints).toString();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			result = Contants.UPDATE_ERROR;
		}
		return result;
	}

	@Override
	public Integer getComplaintsByTypeTotal(String type) {
		try {
			Integer total = complaintsDao.getComplaintsByTypeTotal(type);
			return total;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	public Integer getComplaintsByCategoryTotal(String category) {
		try {
			Integer total = complaintsDao.getComplaintsByCategoryTotal(category);
			return total;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	public Integer getComplaintsByKeywordTotal(String keyword) {
		try {
			Integer total = complaintsDao.getComplaintsByKeywordTotal(keyword);
			return total;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}
}
