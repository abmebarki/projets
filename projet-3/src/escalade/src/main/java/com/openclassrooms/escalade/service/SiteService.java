package com.openclassrooms.escalade.service;

import java.util.List;

import com.openclassrooms.escalade.model.Site;

public interface SiteService {

	public Site findById(int id);
	public List<Site> findAll();
	public List<Site> findAll(int createurId);
	public List<Site> findAll(Site site);
	public List<Site> findByTopoId(int topoId);
	public int create(Site site);
	public int update(Site site);
	public int delete(int id);

}