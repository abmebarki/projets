package com.openclassrooms.escalade.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.model.Topo;

public interface TopoDao {

	public Topo findById(int id);
	public List<Topo> findAll();
	public List<Topo> findAll(int proprietaireId);
	public List<Topo> findBySiteId(int siteId);
	public int create(Topo topo);
	public int update(Topo topo);
	public int delete(int id);

}