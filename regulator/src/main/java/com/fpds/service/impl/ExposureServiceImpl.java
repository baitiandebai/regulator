package com.fpds.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpds.dao.QualityExposureMapper;
import com.fpds.entity.QualityExposure;
import com.fpds.service.inter.ExposureServiceInter;
import com.fpds.util.Contants;

@Service
public class ExposureServiceImpl implements ExposureServiceInter{

	
	private static Logger log = Logger.getLogger(FocusServiceImpl.class);
	
	@Autowired
	private QualityExposureMapper exposureDao;
	
	public QualityExposure getExposureById(String id) {
		try {
			QualityExposure qualityExposure = exposureDao.getExposureById(id);
			return qualityExposure;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

	public List<QualityExposure> getExposureByProductClass(Integer current, Integer size, String productClass1,
			String productClass2) {
		try {
			List<QualityExposure> qualityExposureList = exposureDao.
					getExposureByProductClass(current*size, size, productClass1, productClass2);
			return qualityExposureList;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

	public List<QualityExposure> getExposureByKeyword(Integer current, Integer size, String keyword) {
		try {
			List<QualityExposure> qualityExposureList = exposureDao.getExposureByKeyword(current*size, size, keyword);
			return qualityExposureList;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

	public String saveExposure(QualityExposure qualityFocus) {
		String result;
		try {
			result = exposureDao.saveExposure(qualityFocus) + "";
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			result = Contants.SAVE_ERROR;
		}
		return result;
	}

	public String deleteExposure(String id) {
		String result = null;
		try {
			result = exposureDao.deleteExposure(id).toString();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			result = Contants.DELETE_ERROR;
		}
		return result;
	}

	public String updateExposure(QualityExposure qualityExposure) {
		String result = null;
		try {
			result = exposureDao.updateExposure(qualityExposure).toString();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			result = Contants.UPDATE_ERROR;
		}
		return result;
	}

    public String saveExposureList(List<QualityExposure> qualityExposuresList){
    	String result = null;
    	try {
			result = exposureDao.saveExposureList(qualityExposuresList).toString();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			result = Contants.SAVE_ERROR;
		}
    	return result;
    }

	@Override
	public Integer getExposureByProductClassTotal(String productClass1, String productClass2) {
		try {
			Integer total = exposureDao.getExposureByProductClassTotal(productClass1,productClass2);
			return total;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	public Integer getExposureByKeywordTotal(String keyword) {
		try {
			Integer total = exposureDao.getExposureByKeywordTotal(keyword);
			return total;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

}
