package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Pret;

/**
 * Interface DAO de la classe PRET
 */

public interface PretDao {
	
	public Pret getPret(int id);
	public List<Pret> getAllPret();
	public int addPret(Pret pret);
	public int updatePret(Pret pret);
	public int deletePret(int id);
	
}
