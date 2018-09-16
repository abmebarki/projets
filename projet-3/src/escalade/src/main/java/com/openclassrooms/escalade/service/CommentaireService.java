package com.openclassrooms.escalade.service;

import java.util.List;
import com.openclassrooms.escalade.model.Commentaire;

public interface CommentaireService {

	public Commentaire findById(int id);
	public List<Commentaire> findAll();
	public List<Commentaire> findBySiteId(int siteId);
	public List<Commentaire> findByTopoId(int topoId);
	public int save(Commentaire commentaire, int auteurId);
	public int update(Commentaire commentaire);
	public int delete(int id);
	
}
