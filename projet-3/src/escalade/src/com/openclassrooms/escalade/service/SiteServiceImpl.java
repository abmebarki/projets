package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.escalade.dao.SiteDao;
import com.openclassrooms.escalade.model.Site;

@Service
public class SiteServiceImpl implements SiteService {

	@Autowired
	private SiteDao SiteDao;

	public Site getSite(int id) {
		return SiteDao.getSite(id);
	}

	public List<Site> getAllSite() {
		return SiteDao.getAllSite();
	}

	@Override
	public int addSite(Site userDetails) {
		return SiteDao.addSite(userDetails);
	}

	@Override
	public int updateSite(Site userDetails) {
		return SiteDao.updateSite(userDetails);
	}

	@Override
	public int deleteSite(int id) {
		return SiteDao.deleteSite(id);
	}

	public SiteDao getSiteDao() {
		return SiteDao;
	}

}
