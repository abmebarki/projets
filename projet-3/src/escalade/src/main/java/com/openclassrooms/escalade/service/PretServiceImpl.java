package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.escalade.dao.PretDao;
import com.openclassrooms.escalade.model.Pret;

@Service
public class PretServiceImpl implements PretService {

	@Autowired
	private PretDao PretDao;

	public Pret getPret(int id) {
		return PretDao.getPret(id);
	}

	public List<Pret> getAllPret() {
		return PretDao.getAllPret();
	}

	@Override
	public int addPret(Pret userDetails) {
		return PretDao.addPret(userDetails);
	}

	@Override
	public int updatePret(Pret userDetails) {
		return PretDao.updatePret(userDetails);
	}

	@Override
	public int deletePret(int id) {
		return PretDao.deletePret(id);
	}

	public PretDao getPretDao() {
		return PretDao;
	}

}
