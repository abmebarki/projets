package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.escalade.dao.CommentaireDao;
import com.openclassrooms.escalade.dao.SiteDao;
import com.openclassrooms.escalade.dao.TopoDao;
import com.openclassrooms.escalade.model.Commentaire;
import com.openclassrooms.escalade.model.Site;
import com.openclassrooms.escalade.model.Topo;

@Service
public class TopoServiceImpl implements TopoService {

	@Autowired
	private TopoDao topoDao;
	
	@Autowired
	private SiteDao siteDao;
	
	@Autowired
	private CommentaireDao commentaireDao;

	public Topo getTopo(int id) {
		Topo topo = topoDao.getTopo(id);
		// List des sites décrits par le topo
		List<Site> descriptibles = siteDao.getSites(id);
		topo.setDescriptibles(descriptibles);
		
		// List des commentaires
		List<Commentaire> commentaires = commentaireDao.getCommentairesTopo(id);
		topo.setCommentaires(commentaires);
		return topo;
	}

	public List<Topo> getAllTopo() {
		return topoDao.getAllTopo();
	}

	@Override
	public int addTopo(Topo userDetails) {
		return topoDao.addTopo(userDetails);
	}

	@Override
	public int updateTopo(Topo userDetails) {
		return topoDao.updateTopo(userDetails);
	}

	@Override
	public int deleteTopo(int id) {
		return topoDao.deleteTopo(id);
	}

	public TopoDao getTopoDao() {
		return topoDao;
	}

}
