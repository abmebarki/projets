package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.escalade.dao.SiteDao;
import com.openclassrooms.escalade.dao.SecteurDao;
import com.openclassrooms.escalade.dao.VoieDao;
import com.openclassrooms.escalade.dao.LongueurDao;
import com.openclassrooms.escalade.dao.GrimpeurDao;
import com.openclassrooms.escalade.dao.TopoDao;
import com.openclassrooms.escalade.dao.CommentaireDao;
import com.openclassrooms.escalade.model.Commentaire;
import com.openclassrooms.escalade.model.Grimpeur;
import com.openclassrooms.escalade.model.Longueur;
import com.openclassrooms.escalade.model.Secteur;
import com.openclassrooms.escalade.model.Site;
import com.openclassrooms.escalade.model.Topo;
import com.openclassrooms.escalade.model.Voie;

@Service
public class SiteServiceImpl implements SiteService {

	@Autowired
	private SiteDao siteDao;

	@Autowired
	private SecteurDao secteurDao;

	@Autowired
	private VoieDao voieDao;

	@Autowired
	private LongueurDao longueurDao;
	
	//@Autowired
	//private GrimpeurDao grimpeurDao;
	
	@Autowired
	private TopoDao topoDao;
	
	@Autowired
	private CommentaireDao commentaireDao;

	public Site getSite(int id) {
		Site site = siteDao.getSite(id);
		//Grimpeur createur = grimpeurDao.getGrimpeur(site.getCreateur().getId()) ;  A VERIFIER
		//site.setCreateur(createur);
		List<Secteur> secteurs = secteurDao.getSecteurs(id);
		site.setSecteurs(secteurs);
		for (int i = 0; i < secteurs.size(); i++) {
			List<Voie> voies = voieDao.getVoies(secteurs.get(i).getId());
			secteurs.get(i).setVoies(voies);
			for (int j = 0; j < voies.size(); j++) {
				List<Longueur> longueurs = longueurDao.getLongueurs(voies.get(j).getId());
				voies.get(j).setLongueurs(longueurs);
			}
		}
		// List des topos descripteurs
		List<Topo> descripteurs = topoDao.getTopos(id);
		site.setDescripteurs(descripteurs);
		
		// List des commentaires
		List<Commentaire> commentaires = commentaireDao.getCommentairesSite(id);
		site.setCommentaires(commentaires);
		
		return site;
	}

	public List<Site> getAllSite() {
		List<Site> sites = siteDao.getAllSite();
//		for (int k = 0; k < sites.size(); k++) {
//			List<Secteur> secteurs = SecteurDao.getSecteurs(sites.get(k).getId());
//			sites.get(k).setSecteurs(secteurs);
//			for (int i = 0; i < secteurs.size(); i++) {
//				List<Voie> voies = VoieDao.getVoies(secteurs.get(i).getId());
//				secteurs.get(i).setVoies(voies);
//				for (int j = 0; j < voies.size(); j++) {
//					List<Longueur> longueurs = LongueurDao.getLongueurs(voies.get(j).getId());
//					voies.get(j).setLongueurs(longueurs);
//				}
//			}
//		}
		
		return sites;
	}

	@Override
	public int addSite(Site userDetails) {
		return siteDao.addSite(userDetails);
	}

	@Override
	public int updateSite(Site userDetails) {
		return siteDao.updateSite(userDetails);
	}

	@Override
	public int deleteSite(int id) {
		return siteDao.deleteSite(id);
	}

	public SiteDao getSiteDao() {
		return siteDao;
	}

}
