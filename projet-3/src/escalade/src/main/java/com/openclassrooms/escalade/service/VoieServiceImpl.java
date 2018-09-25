package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.dao.VoieDao;
import com.openclassrooms.escalade.dao.LongueurDao;
import com.openclassrooms.escalade.model.Longueur;
import com.openclassrooms.escalade.model.Voie;

@Service
public class VoieServiceImpl implements VoieService {

	@Autowired
	private VoieDao voieDao;

	@Autowired
	private LongueurService longueurService;
	
	@Override
	@Transactional
	public Voie findById(int voieId) {
		Voie voie = voieDao.findById(voieId);
		List<Longueur> longueurs = longueurService.findByVoieId(voieId);
		voie.setLongueurs(longueurs);
		return voie;
	}

	@Override
	@Transactional
	public List<Voie> findAll() {
		List<Voie> voies = voieDao.findAll();
		return voies;
	}

	@Override
	@Transactional
	public List<Voie> findBySecteurId(int secteurId) {
		List<Voie> voies = voieDao.findBySecteurId(secteurId);
		for(int i = 0; i < voies.size(); i++) {
			voies.get(i).setLongueurs(longueurService.findByVoieId(voies.get(i).getId()));
		}
		return voies;
	}
	
	@Override
	@Transactional
	public int create(Voie voie, int secteurId) {
		int voieId = voieDao.create(voie, secteurId);
		for(int i = 0; i < voie.getLongueurs().size(); i++) {
			longueurService.create(voie.getLongueurs().get(i) , voieId);
		}
		return voieId;
	}

	@Override
	@Transactional
	public int update(Voie voie) {
		int id = voieDao.update(voie);
		for(int i = 0; i < voie.getLongueurs().size(); i++) {
			longueurService.update(voie.getLongueurs().get(i));
		}
		return id;
	}

	@Override
	@Transactional
	public int delete(int id) {
		return voieDao.delete(id);
	}
	
}
