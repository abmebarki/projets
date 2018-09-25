package com.openclassrooms.escalade.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.dao.GrimpeurTopoProprietaireDao;
import com.openclassrooms.escalade.model.Topo;

@Service
public class GrimpeurTopoProprietaireServiceImpl implements GrimpeurTopoProprietaireService {

	@Autowired
	private GrimpeurTopoProprietaireDao grimpeurTopoProprietaireDao;

	@Override
	@Transactional
	public int create(Topo topo) {
		return grimpeurTopoProprietaireDao.create(topo);
	}

}
