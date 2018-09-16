package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Voie findById(int voieId) {
		Voie voie = voieDao.findById(voieId);
		List<Longueur> longueurs = longueurService.findByVoieId(voieId);
		voie.setLongueurs(longueurs);
		return voie;
	}

	@Override
	public List<Voie> findAll() {
		List<Voie> voies = voieDao.findAll();
		return voies;
	}

	@Override
	public List<Voie> findBySecteurId(int secteurId) {
		List<Voie> voies = voieDao.findBySecteurId(secteurId);
		return voies;
	}
	
	@Override
	public int save(Voie voie, int secteurId) {
		int voieId = voieDao.save(voie, secteurId);
		for(int i = 0; i < voie.getLongueurs().size(); i++) {
			longueurService.save(voie.getLongueurs().get(i) , voieId);
		}
		return voieId;
	}

	@Override
	public int update(Voie voie) {
		return voieDao.update(voie);
	}

	@Override
	public int delete(int id) {
		return voieDao.delete(id);
	}

	public VoieDao findByIdDao() {
		return voieDao;
	}

}
