package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Secteur;

/**
 * Interface DAO de la classe SECTEUR
 */

public interface SecteurDao {
	
	public Secteur findById(int id);
	public List<Secteur> findAll();
	public List<Secteur> findBySiteId(int siteId);
	public int create(Secteur secteur, int siteId);
	public int update(Secteur secteur);
	public int delete(int id);
	
}
