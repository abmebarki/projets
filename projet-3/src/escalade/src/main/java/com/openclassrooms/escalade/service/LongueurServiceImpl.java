package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.dao.LongueurDao;
import com.openclassrooms.escalade.model.Longueur;

@Service
public class LongueurServiceImpl implements LongueurService {

	@Autowired
	private LongueurDao longueurDao;

	@Override
	@Transactional
	public Longueur findById(int longueurId) {
		Longueur longueur = longueurDao.findById(longueurId);
		return longueur;
	}

	@Override
	@Transactional
	public List<Longueur> findAll() {
		List<Longueur> longueurs = longueurDao.findAll();
		return longueurs;
	}
	
	@Override
	@Transactional
	public List<Longueur> findByVoieId(int voieId) {
		List<Longueur> longueurs = longueurDao.findByVoieId(voieId);
		return longueurs;
	}

	@Override
	@Transactional
	public int create(Longueur longueur, int voieId) {
		return longueurDao.create(longueur, voieId);
	}

	@Override
	@Transactional
	public int update(Longueur longueur) {
		return longueurDao.update(longueur);
	}

	@Override
	@Transactional
	public int delete(int longueurId) {
		return longueurDao.delete(longueurId);
	}
	
}
