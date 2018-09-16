package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.escalade.dao.SecteurDao;
import com.openclassrooms.escalade.dao.VoieDao;
import com.openclassrooms.escalade.dao.LongueurDao;
import com.openclassrooms.escalade.dao.GrimpeurDao;
import com.openclassrooms.escalade.dao.CommentaireDao;
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
	public List<Secteur> findAll() {
		List<Secteur> secteurs = secteurDao.findAll();
		return secteurs;
	}
	
	@Override
	public List<Secteur> findBySiteId(int siteId) {
		List<Secteur> secteurs = secteurDao.findBySiteId(siteId);
		return secteurs;
	}

	@Override
	public int save(Secteur secteur, int siteId) {
		int id = secteurDao.save(secteur, siteId);
		for(int i = 0; i < secteur.findBySecteurId().size(); i++) {
			voieService.save(secteur.findBySecteurId().get(i) , id);
		}
		return id;
	}

	@Override
	public int update(Secteur secteur) {
		return secteurDao.update(secteur);
	}

	@Override
	public int delete(int secteurId) {
		return secteurDao.delete(secteurId);
	}

	public SecteurDao findByIdDao() {
		return secteurDao;
	}

}
