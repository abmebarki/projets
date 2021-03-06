package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Pret;

/**
 * Interface DAO de la classe PRET
 */

public interface PretDao {
	
	public Pret findById(int id);
	public List<Pret> findAll();
	public List<Pret> findAll(int emprunteurId);
	public List<Pret> findByTopoIdDates(Pret pret);
	public List<Pret> findByTopoIdEmprunteurIdDates(Pret pret);
	public int create(Pret pret);
	public int update(Pret pret);
	public int delete(int id);
	
}
