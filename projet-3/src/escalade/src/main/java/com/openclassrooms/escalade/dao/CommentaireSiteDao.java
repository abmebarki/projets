package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Commentaire;
import com.openclassrooms.escalade.model.Topo;

/**
 * Interface DAO de la classe COMMENTAIRE
 */

public interface CommentaireSiteDao {
	
	public Commentaire findById(int id);
	public List<Commentaire> findBySiteId(int siteId);
	public int create(Commentaire commentaire, int siteId);
	public int update(Commentaire commentaire);
	public int delete(int id);
	
}
