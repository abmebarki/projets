package com.openclassrooms.escalade.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.dao.CommentaireSiteDao;
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
	private CommentaireTopoService commentaireTopoService;
	
	@Autowired
	private GrimpeurService grimpeurService;
	
	@Autowired
	private GrimpeurTopoProprietaireService grimpeurTopoProprietaireService;
	
	@Autowired
	private TopoSiteDescripteurService topoSiteDescripteurService ;

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.topoService#findById(int)
	 */
	@Override
	@Transactional
	public Topo findById(int topoId) {
		Topo topo = topoDao.findById(topoId);
		// List des sites décrits par le topo
		List<Site> descriptibles = siteService.findByTopoId(topoId);
		topo.setDescriptibles(descriptibles);
		
		// List des commentaires
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
	public int create(Topo topo, String selectedSites) {
		
		// Création du créateur
		int createurId = grimpeurService.create(topo.getCreateur());
		
		// Mettre à jour le topo par le créateur Id
		topo.getCreateur().setId(createurId);
		
		// Mettre à jour le topo par le propriétaire Id
		if(topo.getProprietaire() != null) {
			
			// Création du propriétaire
			int proprietaireId = grimpeurService.create(topo.getProprietaire());
			topo.getProprietaire().setId(proprietaireId);
			
		}
		
		// Création du topo
		int topoId = topoDao.create(topo);
		
		// Mettre à jour le topo par son id
		topo.setId(topoId);
		
		// Création du topo proprietaire
		if(topo.getProprietaire() != null) {
			grimpeurTopoProprietaireService.create(topo);
		}
		
		// Ajout des topos
		List<String> sites = Arrays.asList(selectedSites.split(","));
		for(int i = 0; i < sites.size(); i++) {
			topoSiteDescripteurService.create(Integer.valueOf(sites.get(i).trim()), topo.getId());
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
