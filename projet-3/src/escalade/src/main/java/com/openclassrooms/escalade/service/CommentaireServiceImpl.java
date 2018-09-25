package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.dao.CommentaireDao;
import com.openclassrooms.escalade.model.Commentaire;

@Service
public class CommentaireServiceImpl implements CommentaireService {

	@Autowired
	private CommentaireDao CommentaireDao;
	
	@Autowired
	private GrimpeurService grimpeurService;

	@Override
	@Transactional
	public Commentaire findByIdForSite(int id) {
		return CommentaireDao.findByIdForSite(id);
	}

	@Override
	@Transactional
	public Commentaire findByIdForTopo(int id) {
		return CommentaireDao.findByIdForTopo(id);
	}
	
	@Override
	@Transactional
	public List<Commentaire> findBySiteId(int siteId) {
		return CommentaireDao.findBySiteId(siteId);
	}
	
	@Override
	@Transactional
	public List<Commentaire> findByTopoId(int topoId) {
		return CommentaireDao.findByTopoId(topoId);
	}

	@Override
	@Transactional
	public int createBySite(Commentaire commentaire, int siteId) {
		// Création de l'auteur du commentaire
		int auteurId = grimpeurService.create(commentaire.getAuteur());
		
		// Mettre à jour le commentaire par l'auteur Id
		commentaire.getAuteur().setId(auteurId);
		
		return CommentaireDao.createBySite(commentaire, siteId);
	}

	@Override
	@Transactional
	public int updateBySite(Commentaire commentaire) {
		return CommentaireDao.updateBySite(commentaire);
	}

	@Override
	@Transactional
	public int deleteBySite(int commentaireId) {
		return CommentaireDao.deleteBySite(commentaireId);
	}
	
	@Override
	@Transactional
	public int createByTopo(Commentaire commentaire, int topoId) {
		// Création de l'auteur du commentaire
		int auteurId = grimpeurService.create(commentaire.getAuteur());
		
		// Mettre à jour le commentaire par l'auteur Id
		commentaire.getAuteur().setId(auteurId);
		
		return CommentaireDao.createByTopo(commentaire, topoId);
	}

	@Override
	@Transactional
	public int updateByTopo(Commentaire commentaire) {
		return CommentaireDao.updateByTopo(commentaire);
	}

	@Override
	@Transactional
	public int deleteByTopo(int commentaireId) {
		return CommentaireDao.deleteByTopo(commentaireId);
	}
}
