package com.openclassrooms.escalade.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.openclassrooms.escalade.dao.SiteSaisonDao;
import com.openclassrooms.escalade.model.Saison;

@Service
public class SiteSaisonServiceImpl implements SiteSaisonService {

	@Autowired
	private SiteSaisonDao siteSaisonDao;
	
	@Override
	@Transactional
	public List<Saison> findBySiteId(int siteId) {
		return siteSaisonDao.findBySiteId(siteId);
	}
	
	@Override
	@Transactional
	public int create(Integer siteId, Saison saison) {
		return siteSaisonDao.create(siteId, saison);
	}

	@Override
	@Transactional
	public int delete(Integer siteId) {
		return siteSaisonDao.delete(siteId);
	}
}
