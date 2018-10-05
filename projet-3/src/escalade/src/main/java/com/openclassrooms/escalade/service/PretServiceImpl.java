package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.dao.PretDao;
import com.openclassrooms.escalade.model.Pret;
import com.openclassrooms.escalade.model.Topo;

@Service
public class PretServiceImpl implements PretService {

	@Autowired
	private PretDao pretDao;
	
	@Override
	@Transactional
	public Pret findById(int id) {
		return pretDao.findById(id);
	}

	@Override
	@Transactional
	public List<Pret> findAll() {
		return pretDao.findAll();
	}

	@Override
	@Transactional
	public List<Pret> findAll(int emprunteurId) {
		return pretDao.findAll(emprunteurId);
	}
	
	@Override
	@Transactional
	public int create(Pret pret) throws Exception {
		
		// Vérifier la disponibilité du topo
		List<Pret> pretList = pretDao.findByTopoIdDates(pret);
		
		if(!pretList.isEmpty()) {
			throw new Exception("Topo non disponible");
		}
		
		// Création de l'emprunteur
		//int emprunteurId = grimpeurService.create(pret.getEmprunteur());
		
		// Mettre à jour le pret par l'emprunteur Id
		//pret.getEmprunteur().setId(emprunteurId);
		int pretId = pretDao.create(pret);
		
		// Mettre à jour le site par son identifiant id
		pret.setId(pretId);
		
		return pretId;
	}

	@Override
	@Transactional
	public int update(Pret pret) {
		return pretDao.update(pret);
	}

	@Override
	@Transactional
	public int delete(int id) {
		return pretDao.delete(id);
	}
	
}
