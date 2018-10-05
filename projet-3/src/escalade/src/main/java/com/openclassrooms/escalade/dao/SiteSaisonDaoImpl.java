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
import com.openclassrooms.escalade.model.Saison;


/**
 * Classe d'implémentation de {@link SiteSaisonDao}.
 */
@Repository
public class SiteSaisonDaoImpl implements SiteSaisonDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
    
	@Override
	@Transactional
	public List<Saison> findBySiteId(int siteId) {
		List<Saison> saisons = (List<Saison>) jdbcTemplate.query("select * from site_saison where site_id = ?",
				new Object[] { siteId }, new SiteSaisonRowMapper());
		return saisons;
	}
	
	@Override
	@Transactional
	public int create(Integer siteId, Saison saison) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("site_saison");
		Map<String, Object> parameters = new HashMap<String, Object>(2);
		parameters.put("site_id", siteId);
		parameters.put("saison", saison.value());
		Number insertedId = simpleJdbcInsert.execute(parameters);
		return insertedId.intValue();
	}
	
	@Override
	@Transactional
	public int delete(Integer siteId) {
		int resp = jdbcTemplate.update("delete from site_saison where site_id = ?", siteId);
		return resp;
	}

}
