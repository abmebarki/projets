package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.dao.GrimpeurDao;
import com.openclassrooms.escalade.exceptions.NotFoundException;
import com.openclassrooms.escalade.model.Grimpeur;

@Service
public class GrimpeurServiceImpl implements GrimpeurService {

	@Autowired
	private GrimpeurDao grimpeurDao;

	@Override
	@Transactional
	public Grimpeur findById(int grimpeurId) {
		return grimpeurDao.findById(grimpeurId);
	}

	@Override
	@Transactional
	public List<Grimpeur> findAll() {
		List<Grimpeur> grimpeurs = grimpeurDao.findAll();
		return grimpeurs;
	}
	
	@Override
	@Transactional
	public Grimpeur findByIdEmailPassword(String email, String password) throws NotFoundException {
		
		Grimpeur utilisateur = grimpeurDao.findByIdEmailPassword(email, password); 
		
		if(utilisateur == null) {
			throw new NotFoundException();
		}
		
		return utilisateur;
		
	}
	
	@Override
	@Transactional
	public int create(Grimpeur grimpeur) {
		
		Grimpeur grimpeurTmp;
		try {
			// Tester si le grimpeur existe déja
			grimpeurTmp = grimpeurDao.findByNameEmail(grimpeur.getNom(), grimpeur.getEmail()); 
		} catch (EmptyResultDataAccessException e1) {
			// Si le grimpeur n'existe pas
			grimpeurTmp = new Grimpeur();
			grimpeurTmp.setId(grimpeurDao.create(grimpeur));
		}
		
		return grimpeurTmp.getId();
		
	}

	@Override
	@Transactional
	public int update(Grimpeur grimpeur) {
		return grimpeurDao.update(grimpeur);
	}

	@Override
	@Transactional
	public int delete(int grimpeurId) {
		return grimpeurDao.delete(grimpeurId);
	}

}
