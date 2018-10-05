package com.openclassrooms.escalade.service;

import java.util.List;

import com.openclassrooms.escalade.model.Saison;

public interface SiteSaisonService {
	public int create(Integer siteId, Saison saison);
	public List<Saison> findBySiteId(int siteId);
	public int delete(Integer siteId);
}
