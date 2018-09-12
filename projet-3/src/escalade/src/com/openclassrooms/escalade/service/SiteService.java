package com.openclassrooms.escalade.service;

import java.util.List;
import com.openclassrooms.escalade.model.Site;

public interface SiteService {

	public Site getSite(int id);
	public List<Site> getAllSite();
	public int addSite(Site site);
	public int updateSite(Site site);
	public int deleteSite(int id);
	
}
