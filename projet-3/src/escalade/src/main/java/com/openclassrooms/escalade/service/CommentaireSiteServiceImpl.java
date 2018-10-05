package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.dao.CommentaireSiteDao;
import com.openclassrooms.escalade.model.Commentaire;

@Service
public class CommentaireSiteServiceImpl implements CommentaireSiteService {

	@Autowired
	private CommentaireSiteDao CommentaireSiteDao;
	
	@Autowired
	private GrimpeurService grimpeurService;

	@Override
	@Transactional
	public Commentaire findById(int id) {
		return CommentaireSiteDao.findById(id);
	}

	@Override
	@Transactional
	public List<Commentaire> findBySiteId(int siteId) {
		return CommentaireSiteDao.findBySiteId(siteId);
	}
	
	@Override
	@Transactional
	public int create(Commentaire commentaire, int siteId) {
		// Création de l'auteur du commentaire
		//int auteurId = grimpeurService.create(commentaire.getAuteur());
		
		// Mettre à jour le commentaire par l'auteur Id
		//commentaire.getAuteur().setId(auteurId);
		
		return CommentaireSiteDao.create(commentaire, siteId);
	}

	@Override
	@Transactional
	public int update(Commentaire commentaire) {
		return CommentaireSiteDao.update(commentaire);
	}

	@Override
	@Transactional
	public int delete(int commentaireId) {
		return CommentaireSiteDao.delete(commentaireId);
	}

}
