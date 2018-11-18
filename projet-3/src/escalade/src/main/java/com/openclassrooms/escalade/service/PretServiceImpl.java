package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.dao.PretDao;
import com.openclassrooms.escalade.model.Pret;
import com.openclassrooms.escalade.model.Topo;

@Service
public class PretServiceImpl implements PretService {

	@Autowired
	private PretDao pretDao;
	
	@Autowired
	private TopoService topoService;
	
	@Autowired
	private GrimpeurService grimpeurService;
	
	@Override
	@Transactional
	public Pret findById(int id) {
		
		Pret pret = pretDao.findById(id);
		pret.setTopoEmprunte(topoService.findById(pret.getTopoEmprunte().getId()));
		pret.setEmprunteur(grimpeurService.findById(pret.getEmprunteur().getId()));
		return pret;
		
	}

	@Override
	@Transactional
	public List<Pret> findAll() {
		
		List<Pret> prets =  pretDao.findAll();
		
		// détail topo emprunté
		for(Pret pret : prets) {
			pret.setTopoEmprunte(topoService.findById(pret.getTopoEmprunte().getId()));
		}
		
		// détail emprunteur
		for(Pret pret : prets) {
			pret.setEmprunteur(grimpeurService.findById(pret.getEmprunteur().getId()));
		}
		return prets;
		
	}

	@Override
	@Transactional
	public List<Pret> findAll(int emprunteurId) {
		
		List<Pret> prets =  pretDao.findAll(emprunteurId);
		// Ajout des topo_site_descripteur
		for(Pret pret : prets) {
			pret.setTopoEmprunte(topoService.findById(pret.getTopoEmprunte().getId()));
		}
		return prets;
		
	}
	
	@Override
	@Transactional
	public int create(Pret pret) throws Exception {
		
		// Vérifier la disponibilité du topo
		List<Pret> pretList = pretDao.findByTopoIdDates(pret);
		
		if(!pretList.isEmpty()) {
			throw new Exception("Topo non disponible");
		}
		
		// Création de l'emprunteur
		//int emprunteurId = grimpeurService.create(pret.getEmprunteur());
		
		// Mettre à jour le pret par l'emprunteur Id
		//pret.getEmprunteur().setId(emprunteurId);
		int pretId = pretDao.create(pret);
		
		// Mettre à jour le site par son identifiant id
		pret.setId(pretId);
		
		return pretId;
	}

	@Override
	@Transactional
	public int update(Pret pret) throws Exception {
		
		// Vérifier la disponibilité du topo
		List<Pret> pretList = pretDao.findByTopoIdEmprunteurIdDates(pret);
		
		if(!pretList.isEmpty()) {
			throw new Exception("Topo non disponible");
		}
		
		return pretDao.update(pret);
	}

	@Override
	@Transactional
	public int delete(int id) {
		return pretDao.delete(id);
	}
	
}
