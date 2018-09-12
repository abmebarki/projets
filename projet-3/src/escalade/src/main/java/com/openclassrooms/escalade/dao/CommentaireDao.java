package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Commentaire;
import com.openclassrooms.escalade.model.Topo;

/**
 * Interface DAO de la classe COMMENTAIRE
 */

public interface CommentaireDao {
	
	public Commentaire getCommentaire(int id);
	public List<Commentaire> getAllCommentaire();
	public List<Commentaire> getCommentairesSite(int siteID);
	public int addCommentaire(Commentaire commentaire);
	public int updateCommentaire(Commentaire commentaire);
	public int deleteCommentaire(int id);
	
}
