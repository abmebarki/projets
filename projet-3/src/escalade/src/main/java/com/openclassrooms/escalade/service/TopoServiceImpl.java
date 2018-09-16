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
	private SiteService siteService;
	
	@Autowired
	private CommentaireService commentaireService;

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.topoService#findById(int)
	 */
	@Override
	public Topo findById(int topoId) {
		Topo topo = topoDao.findById(topoId);
		// List des sites décrits par le topo
		List<Site> descriptibles = siteService.findByTopoId(topoId);
		topo.setDescriptibles(descriptibles);
		
		// List des commentaires
		List<Commentaire> commentaires = commentaireService.findByTopoId(topoId);
		topo.setCommentaires(commentaires);
		return topo;
	}

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.topoService#findAll()
	 */
	@Override
	public List<Topo> findAll() {
		return topoDao.findAll();
	}

	
	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.topoService#findBySiteId(int)
	 */
	@Override
	public List<Topo> findBySiteId(int siteId) {
		return topoDao.findBySiteId(siteId);
	}
	
	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.topoService#save(com.openclassrooms.escalade.model.Topo)
	 */
	@Override
	public int save(Topo topo) {
		return topoDao.save(topo);
	}

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.topoService#update(com.openclassrooms.escalade.model.Topo)
	 */
	@Override
	public int update(Topo topo) {
		return topoDao.update(topo);
	}

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.topoService#deleteTopo(int)
	 */
	@Override
	public int delete(int topoId) {
		return topoDao.delete(topoId);
	}
	
}
