package com.openclassrooms.escalade.service;

import java.util.List;
import com.openclassrooms.escalade.model.Secteur;

public interface SecteurService {

	public Secteur findById(int id);
	public List<Secteur> findAll();
	public List<Secteur> findBySiteId(int siteId);
	public int save(Secteur secteur, int siteId);
	public int update(Secteur secteur);
	public int delete(int id);
	
}
