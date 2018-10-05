package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.exceptions.NotFoundException;
import com.openclassrooms.escalade.model.Grimpeur;

/**
 * Interface DAO de la classe GRIMPEUR
 */

public interface GrimpeurDao {
	
	public Grimpeur findById(int id);
	public Grimpeur findByIdEmailPassword(String email, String password);
	public Grimpeur findByNameEmail(String name, String email);
	public List<Grimpeur> findAll();
	public int create(Grimpeur grimpeur);
	public int update(Grimpeur grimpeur);
	public int delete(int id);
	
}
