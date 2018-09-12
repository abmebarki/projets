package com.openclassrooms.escalade.service;

import java.util.List;
import com.openclassrooms.escalade.model.Topo;

public interface TopoService {

	public Topo getTopo(int id);
	public List<Topo> getAllTopo();
	public int addTopo(Topo topo);
	public int updateTopo(Topo topo);
	public int deleteTopo(int id);
	
}
