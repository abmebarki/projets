package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Longueur;
import com.openclassrooms.escalade.model.Voie;

/**
 * Interface DAO de la classe LONGUEUR
 */

public interface LongueurDao {
	
	public Longueur findById(int id);
	public List<Longueur> findAll();
	public List<Longueur> findByVoieId(int voieId);
	public int create(Longueur longueur, int voieId);
	public int update(Longueur longueur);
	public int delete(int id);
	
}
