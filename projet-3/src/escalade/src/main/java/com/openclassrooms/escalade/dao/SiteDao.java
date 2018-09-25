package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Site;

public interface SiteDao {

	public Site findById(int id);
	public List<Site> findAll();
	public List<Site> findByTopoId(int topoId);
	public int create(Site site);
	public int update(Site site);
	public int delete(int id);

}




