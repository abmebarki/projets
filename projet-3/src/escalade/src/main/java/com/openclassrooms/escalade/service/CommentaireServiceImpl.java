package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.escalade.dao.CommentaireDao;
import com.openclassrooms.escalade.model.Commentaire;

@Service
public class CommentaireServiceImpl implements CommentaireService {

	@Autowired
	private CommentaireDao CommentaireDao;

	public Commentaire findById(int id) {
		return CommentaireDao.findById(id);
	}

	@Override
	public List<Commentaire> findAll() {
		return CommentaireDao.findAll();
	}
	
	@Override
	public List<Commentaire> findBySiteId(int siteId) {
		return CommentaireDao.findBySiteId(siteId);
	}
	
	@Override
	public List<Commentaire> findByTopoId(int topoId) {
		return CommentaireDao.findByTopoId(topoId);
	}

	@Override
	public int save(Commentaire commentaire, int auteurId) {
		return CommentaireDao.save(commentaire, auteurId);
	}

	@Override
	public int update(Commentaire commentaire) {
		return CommentaireDao.update(commentaire);
	}

	@Override
	public int delete(int commentaireId) {
		return CommentaireDao.delete(commentaireId);
	}
}
