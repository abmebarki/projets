package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Commentaire;


/**
 * Interface DAO de la classe COMMENTAIRE
 */

public interface CommentaireTopoDao {
	
	public Commentaire findById(int id);
	public List<Commentaire> findByTopoId(int topoId);
	public int create(Commentaire commentaire, int topoId);
	public int update(Commentaire commentaire);
	public int delete(int id);
	
}
