package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Longueur;
import com.openclassrooms.escalade.model.Voie;

/**
 * Interface DAO de la classe LONGUEUR
 */

public interface LongueurDao {
	
	public Longueur getLongueur(int id);
	public List<Longueur> getAllLongueur();
	public List<Longueur> getLongueurs(int voieID);
	public int addLongueur(Longueur longueur);
	public int updateLongueur(Longueur longueur);
	public int deleteLongueur(int id);
	
}
