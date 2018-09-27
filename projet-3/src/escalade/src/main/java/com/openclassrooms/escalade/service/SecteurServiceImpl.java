package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.dao.SecteurDao;
import com.openclassrooms.escalade.dao.VoieDao;
import com.openclassrooms.escalade.dao.LongueurDao;
import com.openclassrooms.escalade.dao.GrimpeurDao;
import com.openclassrooms.escalade.dao.CommentaireSiteDao;
import com.openclassrooms.escalade.model.Commentaire;
import com.openclassrooms.escalade.model.Grimpeur;
import com.openclassrooms.escalade.model.Longueur;
import com.openclassrooms.escalade.model.Secteur;
import com.openclassrooms.escalade.model.Voie;

@Service
public class SecteurServiceImpl implements SecteurService {

	@Autowired
	private SecteurDao secteurDao;

	@Autowired
	private VoieService voieService;
	
	@Override
	public Secteur findById(int secteurId) {
		Secteur secteur = secteurDao.findById(secteurId);
		List<Voie> voies = voieService.findBySecteurId(secteurId);
		secteur.setVoies(voies);
		return secteur;
	}

	@Override
	@Transactional
	public List<Secteur> findAll() {
		List<Secteur> secteurs = secteurDao.findAll();
		return secteurs;
	}
	
	@Override
	@Transactional
	public List<Secteur> findBySiteId(int siteId) {
		List<Secteur> secteurs = secteurDao.findBySiteId(siteId);
		for(int i = 0; i < secteurs.size(); i++) {
			secteurs.get(i).setVoies(voieService.findBySecteurId(secteurs.get(i).getId()));
		}
		return secteurs;
	}

	@Override
	@Transactional
	public int create(Secteur secteur, int siteId) {
		int id = secteurDao.create(secteur, siteId);
		for(int i = 0; i < secteur.getVoies().size(); i++) {
			voieService.create(secteur.getVoies().get(i) , id);
		}
		return id;
	}

	@Override
	@Transactional
	public int update(Secteur secteur) {
		int id = secteurDao.update(secteur);
		for(int i = 0; i < secteur.getVoies().size(); i++) {
			voieService.update(secteur.getVoies().get(i));
		}
		return id;
	}

	@Override
	@Transactional
	public int delete(int secteurId) {
		return secteurDao.delete(secteurId);
	}
}
