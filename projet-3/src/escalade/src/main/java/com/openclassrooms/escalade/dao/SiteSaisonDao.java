package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Saison;

/**
 * Interface DAO de la classe TOPO
 */

public interface SiteSaisonDao {
	public int create(Integer siteId, Saison saison);
	public List<Saison> findBySiteId(int siteId);
	public int delete(Integer siteId);
}
