package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	private CommentaireTopoService commentaireTopoService;
	
	@Autowired
	private TopoSiteDescripteurService topoSiteDescripteurService ;

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.topoService#findById(int)
	 */
	@Override
	@Transactional
	public Topo findById(int topoId) {
		Topo topo = topoDao.findById(topoId);
		// Liste des sites décrits par le topo
		List<Site> descriptibles = siteService.findByTopoId(topoId);
		topo.setDescriptibles(descriptibles);
		
		// Liste des commentaires
		List<Commentaire> commentaires = commentaireTopoService.findByTopoId(topoId);
		topo.setCommentaires(commentaires);
		return topo;
	}

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.topoService#findAll()
	 */
	@Override
	@Transactional
	public List<Topo> findAll() {
		return topoDao.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.topoService#findAll()
	 */
	@Override
	@Transactional
	public List<Topo> findAll(int proprietaireId) {
		return topoDao.findAll(proprietaireId);
	}
	
	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.topoService#findBySiteId(int)
	 */
	@Override
	@Transactional
	public List<Topo> findBySiteId(int siteId) {
		return topoDao.findBySiteId(siteId);
	}
	
	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.topoService#create(com.openclassrooms.escalade.model.Topo)
	 */
	@Override
	@Transactional
	public int create(Topo topo) {
		
		// Mettre à jour le topo par le propriétaire Id
		// Création du propriétaire
		//int proprietaireId = grimpeurService.create(topo.getProprietaire());
		//topo.getProprietaire().setId(proprietaireId);
		
		// Création du topo
		int topoId = topoDao.create(topo);
		
		// Mettre à jour le topo par son id
		topo.setId(topoId);
		
		// Ajout des topo_site_descripteur
		for(Site site : topo.getDescriptibles()) {
			topoSiteDescripteurService.create(Integer.valueOf(site.getId()), topo.getId());
		}
		
		return topoId;
	}

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.topoService#update(com.openclassrooms.escalade.model.Topo)
	 */
	@Override
	@Transactional
	public int update(Topo topo) {
		return topoDao.update(topo);
	}

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.topoService#deleteTopo(int)
	 */
	@Override
	@Transactional
	public int delete(int topoId) {
		return topoDao.delete(topoId);
	}
	
}
