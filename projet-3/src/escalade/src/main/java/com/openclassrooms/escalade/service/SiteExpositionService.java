package com.openclassrooms.escalade.service;

import java.util.List;

import com.openclassrooms.escalade.model.Exposition;

public interface SiteExpositionService {
	public int create(Integer siteId, Exposition exposition);
	public List<Exposition> findBySiteId(int siteId);
	public int delete(Integer siteId);
}
