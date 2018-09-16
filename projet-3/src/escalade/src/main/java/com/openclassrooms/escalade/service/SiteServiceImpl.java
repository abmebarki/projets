package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.escalade.dao.SiteDao;
import com.openclassrooms.escalade.model.Commentaire;
import com.openclassrooms.escalade.model.Grimpeur;
import com.openclassrooms.escalade.model.Secteur;
import com.openclassrooms.escalade.model.Site;
import com.openclassrooms.escalade.model.Topo;

@Service
public class SiteServiceImpl implements SiteService{

	@Autowired
	private SiteDao siteDao;

	@Autowired
	private SecteurService secteurService;

	@Autowired
	private GrimpeurService grimpeurService;
	
	@Autowired
	private TopoService topoService;
	
	@Autowired
	private CommentaireService commentaireService;

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.SiteService#findById(int)
	 */
	@Override
	public Site findById(int siteId) {
		Site site = siteDao.findById(siteId);
		Grimpeur createur = grimpeurService.findById(site.getCreateur().getId()) ; 
		site.setCreateur(createur);
		List<Secteur> secteurs = secteurService.findBySiteId(siteId);
		site.setSecteurs(secteurs);
		
		// List des topos descripteurs
		List<Topo> descripteurs = topoService.findBySiteId(siteId);
		site.setDescripteurs(descripteurs);
		
		// List des commentaires
		List<Commentaire> commentaires = commentaireService.findBySiteId(siteId);
		site.setCommentaires(commentaires);
		
		return site;
	}

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.SiteService#findAll()
	 */
	@Override
	public List<Site> findAll() {
		List<Site> sites = siteDao.findAll();
		return sites;
	}
	
	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.SiteService#findByTopoId(int)
	 */
	@Override
	public List<Site> findByTopoId(int topoId) {
		List<Site> sites = siteDao.findByTopoId(topoId);
		return sites;
	}

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.SiteService#save(com.openclassrooms.escalade.model.Site)
	 */
	@Override
	public int save(Site site) {
		int siteId = siteDao.save(site);
		for(int i = 0; i < site.getSecteurs().size(); i++) {
			secteurService.save(site.getSecteurs().get(i), siteId);
		}
		return siteId;
	}

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.SiteService#update(com.openclassrooms.escalade.model.Site)
	 */
	@Override
	public int update(Site site) {
		return siteDao.update(site);
	}

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.SiteService#delete(int)
	 */
	@Override
	public int delete(int siteId) {
		return siteDao.delete(siteId);
	}
	
}
