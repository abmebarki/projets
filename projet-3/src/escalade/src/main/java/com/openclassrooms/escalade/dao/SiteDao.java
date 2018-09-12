package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Site;

/**
 * Interface DAO de la classe SITE
 */

public interface SiteDao {
	
	public Site getSite(int id);
	public List<Site> getAllSite();
	public List<Site> getSites(int topoID);
	public int addSite(Site site);
	public int updateSite(Site site);
	public int deleteSite(int id);
	
}
