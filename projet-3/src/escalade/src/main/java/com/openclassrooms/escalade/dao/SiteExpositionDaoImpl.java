package com.openclassrooms.escalade.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.model.Exposition;


/**
 * Classe d'implémentation de {@link SiteExpositionDao}.
 */
@Repository
public class SiteExpositionDaoImpl implements SiteExpositionDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
     
	@Override
	@Transactional
	public List<Exposition> findBySiteId(int siteId) {
		List<Exposition> expositions = (List<Exposition>) jdbcTemplate.query("select * from site_exposition where site_id = ?",
				new Object[] { siteId }, new SiteExpositionRowMapper());
		return expositions;
	}
	
	@Override
	@Transactional
	public int create(Integer siteId, Exposition exposition) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("site_exposition");
		Map<String, Object> parameters = new HashMap<String, Object>(2);
		parameters.put("site_id", siteId);
		parameters.put("exposition", exposition.value());
		Number insertedId = simpleJdbcInsert.execute(parameters);
		return insertedId.intValue();
	}
	
	@Override
	@Transactional
	public int delete(Integer siteId) {
		int resp = jdbcTemplate.update("delete from site_exposition where site_id = ?", siteId);
		return resp;
	}

}
