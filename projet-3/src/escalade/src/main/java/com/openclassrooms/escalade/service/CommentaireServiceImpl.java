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

	public Commentaire getCommentaire(int id) {
		return CommentaireDao.getCommentaire(id);
	}

	public List<Commentaire> getAllCommentaire() {
		return CommentaireDao.getAllCommentaire();
	}

	@Override
	public int addCommentaire(Commentaire userDetails) {
		return CommentaireDao.addCommentaire(userDetails);
	}

	@Override
	public int updateCommentaire(Commentaire userDetails) {
		return CommentaireDao.updateCommentaire(userDetails);
	}

	@Override
	public int deleteCommentaire(int id) {
		return CommentaireDao.deleteCommentaire(id);
	}

	public CommentaireDao getCommentaireDao() {
		return CommentaireDao;
	}

}
