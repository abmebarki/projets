package com.openclassrooms.escalade.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	private CommentaireSiteService commentaireService;
	
	@Autowired
	private TopoSiteDescripteurService topoSiteDescripteurService ;

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.SiteService#findById(int)
	 */
	@Override
	@Transactional
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
	@Transactional
	public List<Site> findAll() {
		List<Site> sites = siteDao.findAll();
		return sites;
	}
	
	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.SiteService#findByTopoId(int)
	 */
	@Override
	@Transactional
	public List<Site> findByTopoId(int topoId) {
		List<Site> sites = siteDao.findByTopoId(topoId);
		return sites;
	}

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.SiteService#create(com.openclassrooms.escalade.model.Site)
	 */
	@Override
	@Transactional
	public int create(Site site, String selectedTopos) {
		
		// Création du créateur
		int createurId = grimpeurService.create(site.getCreateur());
		
		// Mettre à jour le site par le créateur Id
		site.getCreateur().setId(createurId);
		
		// Création du site
		int siteId = siteDao.create(site);
		
		// Mettre à jour le site par son identifiant id
		site.setId(siteId);
		
		// Création des secteurs
		for(int i = 0; i < site.getSecteurs().size(); i++) {
			secteurService.create(site.getSecteurs().get(i), siteId);
		}
		
		// Ajout des topos
		List<String> topos = Arrays.asList(selectedTopos.split(","));
		for(int i = 0; i < topos.size(); i++) {
			topoSiteDescripteurService.create(site.getId(),Integer.valueOf(topos.get(i).trim()));
		}
		
		return siteId;
	}

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.SiteService#update(com.openclassrooms.escalade.model.Site)
	 */
	@Override
	@Transactional
	public int update(Site site) {
		int id = siteDao.update(site);
		
		// mise jour des secteurs
		for(int i = 0; i < site.getSecteurs().size(); i++) {
			secteurService.update(site.getSecteurs().get(i));
		}
		// mise à jour du créateur
		grimpeurService.update(site.getCreateur());
		return id;
		
	}

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.SiteService#delete(int)
	 */
	@Override
	@Transactional
	public int delete(int siteId) {
		return siteDao.delete(siteId);
	}
	
}
