package com.openclassrooms.escalade.service;

import java.util.List;
import com.openclassrooms.escalade.model.Pret;

public interface PretService {

	public Pret findById(int id);
	public List<Pret> findAll();
	public List<Pret> findAll(int emprunteurId);
	public int create(Pret pret) throws Exception;
	public int update(Pret pret);
	public int delete(int id);
	
}
