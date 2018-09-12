package com.openclassrooms.escalade.service;

import java.util.List;
import com.openclassrooms.escalade.model.Commentaire;

public interface CommentaireService {

	public Commentaire getCommentaire(int id);
	public List<Commentaire> getAllCommentaire();
	public int addCommentaire(Commentaire commentaire);
	public int updateCommentaire(Commentaire commentaire);
	public int deleteCommentaire(int id);
	
}
