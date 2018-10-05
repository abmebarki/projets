package com.openclassrooms.escalade.service;

import java.util.List;

import com.openclassrooms.escalade.exceptions.NotFoundException;
import com.openclassrooms.escalade.model.Grimpeur;

public interface GrimpeurService {

	public Grimpeur findById(int id);
	public Grimpeur findByIdEmailPassword(String email, String password) throws NotFoundException;
	public List<Grimpeur> findAll();
	public int create(Grimpeur grimpeur);
	public int update(Grimpeur grimpeur);
	public int delete(int id);
	
	
}
