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

	public Pret findById(int pretId) {
		return PretDao.findById(pretId);
	}

	public List<Pret> findAll() {
		return PretDao.findAll();
	}

	@Override
	public int save(Pret pret) {
		return PretDao.save(pret);
	}

	@Override
	public int update(Pret pret) {
		return PretDao.update(pret);
	}

	@Override
	public int delete(int pretId) {
		return PretDao.delete(pretId);
	}
	
}
