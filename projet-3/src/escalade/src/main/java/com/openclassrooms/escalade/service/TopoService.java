package com.openclassrooms.escalade.service;

import java.util.List;

import com.openclassrooms.escalade.model.Topo;

public interface TopoService {

	public Topo findById(int id);
	public List<Topo> findAll();
	public List<Topo> findBySiteId(int siteId);
	public int create(Topo topo, String selectedSites);
	public int update(Topo topo);
	public int delete(int id);

}