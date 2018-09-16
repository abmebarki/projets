package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.openclassrooms.escalade.dao.LongueurDao;
import com.openclassrooms.escalade.model.Longueur;

@Service
public class LongueurServiceImpl implements LongueurService {

	@Autowired
	private LongueurDao longueurDao;

	@Override
	public Longueur findById(int longueurId) {
		Longueur longueur = longueurDao.findById(longueurId);
		return longueur;
	}

	@Override
	public List<Longueur> findAll() {
		List<Longueur> longueurs = longueurDao.findAll();
		return longueurs;
	}
	
	@Override
	public List<Longueur> findByVoieId(int voieId) {
		List<Longueur> longueurs = longueurDao.findByVoieId(voieId);
		return longueurs;
	}

	@Override
	public int save(Longueur longueur, int voieId) {
		return longueurDao.save(longueur, voieId);
	}

	@Override
	public int update(Longueur longueur) {
		return longueurDao.update(longueur);
	}

	@Override
	public int delete(int longueurId) {
		return longueurDao.delete(longueurId);
	}

	public LongueurDao getLongueurDao() {
		return longueurDao;
	}

}
