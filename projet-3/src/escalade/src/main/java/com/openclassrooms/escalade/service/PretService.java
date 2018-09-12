package com.openclassrooms.escalade.service;

import java.util.List;
import com.openclassrooms.escalade.model.Pret;

public interface PretService {

	public Pret getPret(int id);
	public List<Pret> getAllPret();
	public int addPret(Pret pret);
	public int updatePret(Pret pret);
	public int deletePret(int id);
	
}
