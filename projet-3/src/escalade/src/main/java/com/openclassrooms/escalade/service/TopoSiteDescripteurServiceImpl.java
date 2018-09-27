package com.openclassrooms.escalade.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.openclassrooms.escalade.dao.TopoSiteDescripteurDao;
import com.openclassrooms.escalade.model.Site;

@Service
public class TopoSiteDescripteurServiceImpl implements TopoSiteDescripteurService {

	@Autowired
	private TopoSiteDescripteurDao topoSiteDescripteurDao;

	@Override
	@Transactional
	public int create(Integer siteId, Integer topoId) {
		return topoSiteDescripteurDao.create(siteId, topoId);
	}

}
