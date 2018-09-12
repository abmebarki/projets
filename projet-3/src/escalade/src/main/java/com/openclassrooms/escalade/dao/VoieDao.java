package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Voie;

/**
 * Interface DAO de la classe VOIE
 */

public interface VoieDao {
	
	public Voie getVoie(int id);
	public List<Voie> getAllVoie();
	public List<Voie> getVoies(int secteurID); 
	public int addVoie(Voie voie);
	public int updateVoie(Voie voie);
	public int deleteVoie(int id);
	
}
