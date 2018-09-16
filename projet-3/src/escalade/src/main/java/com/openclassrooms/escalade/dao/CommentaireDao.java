package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Commentaire;
import com.openclassrooms.escalade.model.Topo;

/**
 * Interface DAO de la classe COMMENTAIRE
 */

public interface CommentaireDao {
	
	public Commentaire findById(int id);
	public List<Commentaire> findAll();
	public List<Commentaire> findBySiteId(int siteId);
	public List<Commentaire> findByTopoId(int topoId);
	public int save(Commentaire commentaire, int auteurId);
	public int update(Commentaire commentaire);
	public int delete(int id);
	
}
