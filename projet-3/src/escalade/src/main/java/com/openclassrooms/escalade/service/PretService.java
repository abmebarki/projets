package com.openclassrooms.escalade.service;

import java.util.List;
import com.openclassrooms.escalade.model.Pret;

public interface PretService {

	public Pret findById(int id);
	public List<Pret> findAll();
	public int create(Pret pret);
	public int update(Pret pret);
	public int delete(int id);
	
}
