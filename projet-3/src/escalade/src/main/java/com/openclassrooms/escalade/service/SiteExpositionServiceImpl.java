package com.openclassrooms.escalade.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.openclassrooms.escalade.dao.SiteExpositionDao;
import com.openclassrooms.escalade.model.Exposition;

@Service
public class SiteExpositionServiceImpl implements SiteExpositionService {

	@Autowired
	private SiteExpositionDao siteExpositionDao;

	
	@Override
	@Transactional
	public List<Exposition> findBySiteId(int siteId) {
		return siteExpositionDao.findBySiteId(siteId);
	}
	
	@Override
	@Transactional
	public int create(Integer siteId, Exposition exposition) {
		return siteExpositionDao.create(siteId, exposition);
	}
	
	@Override
	@Transactional
	public int delete(Integer siteId) {
		return siteExpositionDao.delete(siteId);
	}

}
