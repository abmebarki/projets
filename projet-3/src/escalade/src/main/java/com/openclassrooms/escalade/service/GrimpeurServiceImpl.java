package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.escalade.dao.GrimpeurDao;
import com.openclassrooms.escalade.model.Grimpeur;

@Service
public class GrimpeurServiceImpl implements GrimpeurService {

	@Autowired
	private GrimpeurDao grimpeurDao;

	@Override
	public Grimpeur findById(int grimpeurId) {
		return grimpeurDao.findById(grimpeurId);
	}

	@Override
	public List<Grimpeur> findAll() {
		List<Grimpeur> grimpeurs = grimpeurDao.findAll();
		return grimpeurs;
	}
	
	@Override
	public int save(Grimpeur grimpeur) {
		return grimpeurDao.save(grimpeur);
	}

	@Override
	public int update(Grimpeur grimpeur) {
		return grimpeurDao.update(grimpeur);
	}

	@Override
	public int delete(int grimpeurId) {
		return grimpeurDao.delete(grimpeurId);
	}

}
