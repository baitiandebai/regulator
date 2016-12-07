package com.fpds.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpds.dao.QualityFocusMapper;
import com.fpds.entity.QualityFocus;
import com.fpds.service.inter.FocusServiceInter;
import com.fpds.util.Contants;

@Service
public class FocusServiceImpl implements FocusServiceInter {

	private static Logger log = Logger.getLogger(FocusServiceImpl.class);
	
	@Autowired
	private QualityFocusMapper focusDao;
	
	public QualityFocus getNewById(String id) {
		try {
			QualityFocus qualityFocus = focusDao.getNewById(id);
			return qualityFocus;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

	public String saveNew(QualityFocus qualityFocus) {
		String result;
		try {
			result = focusDao.saveNew(qualityFocus) + "";
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			result = Contants.SAVE_ERROR;
		}
		return result;
	}

	public String deleteNew(String id) {
		String result = null;
		try {
			result = focusDao.deleteNew(id).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			result = Contants.DELETE_ERROR;
		}
		return result;
	}

	public String updateNew(QualityFocus qualityFocus) {
		String result = null;
		try {
			result = focusDao.updateNew(qualityFocus).toString();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			result = Contants.UPDATE_ERROR;
		}
		return result;
	}

	public List<QualityFocus> getNewByType(Integer current, Integer size, String type) {
		try {
			List<QualityFocus> qualityFocusList = focusDao.getNewByType(current*size, size, type);
			return qualityFocusList;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

	public List<QualityFocus> getNewByCategory(Integer current, Integer size, String category) {
		try {
			List<QualityFocus> qualityFocusList = focusDao.getNewByCategory(current*size, size, category);
			return qualityFocusList;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

	public List<QualityFocus> getNewByKeyword(Integer current, Integer size, String keyword) {
		
		try {
			List<QualityFocus> qualityFocusList = focusDao.getNewByKeyword(current*size, size, keyword);
			return qualityFocusList;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

}
