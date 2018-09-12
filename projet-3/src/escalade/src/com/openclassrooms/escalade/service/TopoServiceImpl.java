package com.openclassrooms.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.escalade.dao.TopoDao;
import com.openclassrooms.escalade.model.Topo;

@Service
public class TopoServiceImpl implements TopoService {

	@Autowired
	private TopoDao TopoDao;

	public Topo getTopo(int id) {
		return TopoDao.getTopo(id);
	}

	public List<Topo> getAllTopo() {
		return TopoDao.getAllTopo();
	}

	@Override
	public int addTopo(Topo userDetails) {
		return TopoDao.addTopo(userDetails);
	}

	@Override
	public int updateTopo(Topo userDetails) {
		return TopoDao.updateTopo(userDetails);
	}

	@Override
	public int deleteTopo(int id) {
		return TopoDao.deleteTopo(id);
	}

	public TopoDao getTopoDao() {
		return TopoDao;
	}

}
