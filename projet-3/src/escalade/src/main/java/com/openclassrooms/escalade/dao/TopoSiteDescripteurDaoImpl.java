package com.openclassrooms.escalade.dao;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Classe d'implémentation de {@link TopoSiteDescripteurDao}.
 */
@Repository
public class TopoSiteDescripteurDaoImpl implements TopoSiteDescripteurDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
        
	@Transactional
	public int create(Integer siteId, Integer topoId) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("topo_site_descipteur");
		Map<String, Object> parameters = new HashMap<String, Object>(2);
		parameters.put("site_id", siteId);
		parameters.put("topo_id", topoId);
		Number insertedId = simpleJdbcInsert.execute(parameters);
		return insertedId.intValue();
	}

}
