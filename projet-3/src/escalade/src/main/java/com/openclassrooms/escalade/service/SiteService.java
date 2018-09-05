package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.openclassrooms.escalade.dao.SiteDao;
import com.openclassrooms.escalade.model.Site;

@Component
public class SiteService {

	@Autowired
	private SiteDao siteDao = null;

//	 public Site getSite(@PathVariable String id){
//	        return siteDao.get(id);
//	 }
	
	public List<Site> getListSite() {
		return siteDao.getListSite();
		
	}
	
}
