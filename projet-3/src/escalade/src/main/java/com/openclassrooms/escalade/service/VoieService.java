package com.openclassrooms.escalade.service;

import java.util.List;
import com.openclassrooms.escalade.model.Voie;

public interface VoieService {

	public Voie findById(int id);
	public List<Voie> findAll();
	public List<Voie> findBySecteurId(int secteurId);
	public int save(Voie voie, int secteurId);
	public int update(Voie voie);
	public int delete(int id);
	
}
