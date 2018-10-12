package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.dao.SiteDao;
import com.openclassrooms.escalade.model.Commentaire;
import com.openclassrooms.escalade.model.Exposition;
import com.openclassrooms.escalade.model.Grimpeur;
import com.openclassrooms.escalade.model.Saison;
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
	
	@Autowired
	private SiteExpositionService siteExpositionService;
	
	@Autowired
	private SiteSaisonService siteSaisonService;
	

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
		
		//Liste expositions
		List<Exposition> expositions = siteExpositionService.findBySiteId(siteId);
		site.setExpositions(expositions);
		
		//Liste saisons
		List<Saison> saisons = siteSaisonService.findBySiteId(siteId);
		site.setSaisons(saisons);
		
		// Liste des topos descripteurs
		List<Topo> descripteurs = topoService.findBySiteId(siteId);
		site.setDescripteurs(descripteurs);
		
		// Liste des commentaires
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
	 * @see com.openclassrooms.escalade.service.SiteService#findAll()
	 */
	@Override
	@Transactional
	public List<Site> findAll(int createurId) {
		List<Site> sites = siteDao.findAll(createurId);
		return sites;
	}
	
	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.service.SiteService#findAll()
	 */
	@Override
	@Transactional
	public List<Site> findAll(Site site) {
		List<Site> sites = siteDao.findAll(site);
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
	public int create(Site site) {
		
		// Création du créateur
		//int createurId = grimpeurService.create(site.getCreateur());
		
		// Mettre à jour le site par le créateur Id
		//site.getCreateur().setId(utilisateur.getId());
		
		// Création du site
		int siteId = siteDao.create(site);
		
		// Mettre à jour le site par son identifiant id
		site.setId(siteId);
		
		// Expositions
		for(int i = 0; i < site.getExpositions().size(); i++) {
			siteExpositionService.create(site.getId(), site.getExpositions().get(i));
		}
		
		// Saisons préférées
		for(int i = 0; i < site.getSaisons().size(); i++) {
			siteSaisonService.create(site.getId(), site.getSaisons().get(i));
		}
		
		// Création des secteurs
		for(int i = 0; i < site.getSecteurs().size(); i++) {
			secteurService.create(site.getSecteurs().get(i), siteId);
		}
		
		// Ajout des topo_site_descripteur
		for(Topo topo : site.getDescripteurs()) {
			topoSiteDescripteurService.create(site.getId(), Integer.valueOf(topo.getId()));
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
		
		// Suppression avant l'insertion
		siteExpositionService.delete(site.getId());
		siteSaisonService.delete(site.getId());
		
		// Expositions
		for(int i = 0; i < site.getExpositions().size(); i++) {
			siteExpositionService.create(site.getId(), site.getExpositions().get(i));
		}
		
		// Saisons préférées
		for(int i = 0; i < site.getSaisons().size(); i++) {
			siteSaisonService.create(site.getId(), site.getSaisons().get(i));
		}
		
		
		// mise jour des secteurs
		for(int i = 0; i < site.getSecteurs().size(); i++) {
			secteurService.update(site.getSecteurs().get(i));
		}
		// mise à jour du créateur
		//grimpeurService.update(site.getCreateur());
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
