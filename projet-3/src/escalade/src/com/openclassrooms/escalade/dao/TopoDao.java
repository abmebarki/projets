package com.openclassrooms.escalade.dao;

import java.util.List;

import com.openclassrooms.escalade.model.Topo;

/**
 * Interface DAO de la classe TOPO
 */

public interface TopoDao {
	
	public Topo getTopo(int id);
	public List<Topo> getAllTopo();
	public int addTopo(Topo topo);
	public int updateTopo(Topo topo);
	public int deleteTopo(int id);
	
}
