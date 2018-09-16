package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Voie;

/**
 * Interface DAO de la classe VOIE
 */

public interface VoieDao {
	
	public Voie findById(int id);
	public List<Voie> findAll();
	public List<Voie> findBySecteurId(int secteurId); 
	public int save(Voie voie, int secteurId);
	public int update(Voie voie);
	public int delete(int id);
	
}
