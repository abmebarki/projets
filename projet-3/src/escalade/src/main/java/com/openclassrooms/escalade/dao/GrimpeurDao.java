package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Grimpeur;

/**
 * Interface DAO de la classe GRIMPEUR
 */

public interface GrimpeurDao {
	
	public Grimpeur findById(int id);
	public List<Grimpeur> findAll();
	public int save(Grimpeur grimpeur);
	public int update(Grimpeur grimpeur);
	public int delete(int id);
	
}
