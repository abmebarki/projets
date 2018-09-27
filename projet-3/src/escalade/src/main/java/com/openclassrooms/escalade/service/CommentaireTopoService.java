package com.openclassrooms.escalade.service;

import java.util.List;
import com.openclassrooms.escalade.model.Commentaire;

public interface CommentaireTopoService {
	
	public Commentaire findById(int id);
	public List<Commentaire> findByTopoId(int topoId);
	public int create(Commentaire commentaire, int topoId);
	public int update(Commentaire commentaire);
	public int delete(int id);
	
}
