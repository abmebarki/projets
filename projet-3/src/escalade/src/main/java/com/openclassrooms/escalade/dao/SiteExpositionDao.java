package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Exposition;

/**
 * Interface DAO de la classe TOPO
 */

public interface SiteExpositionDao {
	public List<Exposition> findBySiteId(int siteId);
	public int create(Integer siteId, Exposition exposition);
	public int delete(Integer siteId);
}
