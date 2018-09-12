package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Secteur;

/**
 * Interface DAO de la classe SECTEUR
 */

public interface SecteurDao {
	
	public Secteur getSecteur(int id);
	public List<Secteur> getAllSecteur();
	public List<Secteur> getSecteurs(int siteID);
	public int addSecteur(Secteur secteur);
	public int updateSecteur(Secteur secteur);
	public int deleteSecteur(int id);
	
}
