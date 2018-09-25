package com.openclassrooms.escalade.service;

import java.util.List;
import com.openclassrooms.escalade.model.Longueur;

public interface LongueurService {

	public Longueur findById(int id);
	public List<Longueur> findAll();
	public List<Longueur> findByVoieId(int voieId);
	public int create(Longueur longueur, int voieId);
	public int update(Longueur longueur);
	public int delete(int id);
	
}
