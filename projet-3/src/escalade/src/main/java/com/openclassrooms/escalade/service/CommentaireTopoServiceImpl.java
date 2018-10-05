package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.dao.CommentaireTopoDao;
import com.openclassrooms.escalade.model.Commentaire;

@Service
public class CommentaireTopoServiceImpl implements CommentaireTopoService {

	@Autowired
	private CommentaireTopoDao CommentaireTopoDao;
	
	@Autowired
	private GrimpeurService grimpeurService;

	@Override
	@Transactional
	public Commentaire findById(int id) {
		return CommentaireTopoDao.findById(id);
	}
	
	@Override
	@Transactional
	public List<Commentaire> findByTopoId(int topoId) {
		return CommentaireTopoDao.findByTopoId(topoId);
	}

	@Override
	@Transactional
	public int create(Commentaire commentaire, int topoId) {
		// Création de l'auteur du commentaire
		//int auteurId = grimpeurService.create(commentaire.getAuteur());
		
		// Mettre à jour le commentaire par l'auteur Id
		//commentaire.getAuteur().setId(auteurId);
		
		return CommentaireTopoDao.create(commentaire, topoId);
	}

	@Override
	@Transactional
	public int update(Commentaire commentaire) {
		return CommentaireTopoDao.update(commentaire);
	}

	@Override
	@Transactional
	public int delete(int commentaireId) {
		return CommentaireTopoDao.delete(commentaireId);
	}
}
