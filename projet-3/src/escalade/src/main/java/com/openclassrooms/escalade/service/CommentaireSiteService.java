package com.openclassrooms.escalade.service;

import java.util.List;
import com.openclassrooms.escalade.model.Commentaire;

public interface CommentaireSiteService {
	
	public Commentaire findById(int id);
	public List<Commentaire> findBySiteId(int siteId);
	public int create(Commentaire commentaire, int siteId);
	public int update(Commentaire commentaire);
	public int delete(int id);
	
}
