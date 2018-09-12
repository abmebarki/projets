package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Grimpeur;

/**
 * Interface DAO de la classe GRIMPEUR
 */

public interface GrimpeurDao {
	
	public Grimpeur getGrimpeur(int id);
	public List<Grimpeur> getAllGrimpeur();
	public int addGrimpeur(Grimpeur grimpeur);
	public int updateGrimpeur(Grimpeur grimpeur);
	public int deleteGrimpeur(int id);
	
}
