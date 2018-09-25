package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.dao.PretDao;
import com.openclassrooms.escalade.model.Pret;

@Service
public class PretServiceImpl implements PretService {

	@Autowired
	private PretDao PretDao;

	public Pret findById(int pretId) {
		return PretDao.findById(pretId);
	}

	@Override
	@Transactional
	public List<Pret> findAll() {
		return PretDao.findAll();
	}

	@Override
	@Transactional
	public int create(Pret pret) {
		return PretDao.create(pret);
	}

	@Override
	@Transactional
	public int update(Pret pret) {
		return PretDao.update(pret);
	}

	@Override
	@Transactional
	public int delete(int pretId) {
		return PretDao.delete(pretId);
	}
	
}
