package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Commentaire;
import com.openclassrooms.escalade.model.Topo;

/**
 * Interface DAO de la classe COMMENTAIRE
 */

public interface CommentaireDao {
	
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
