package com.openclassrooms.escalade.service;

import java.util.List;
import com.openclassrooms.escalade.model.Commentaire;

public interface CommentaireService {

	public Commentaire findByIdForSite(int id);
	public Commentaire findByIdForTopo(int id);
	public List<Commentaire> findBySiteId(int siteId);
	public List<Commentaire> findByTopoId(int topoId);
	public int createBySite(Commentaire commentaire, int siteId);
	public int updateBySite(Commentaire commentaire);
	public int deleteBySite(int id);
	public int createByTopo(Commentaire commentaire, int topoId);
	public int updateByTopo(Commentaire commentaire);
	public int deleteByTopo(int id);
	
}
