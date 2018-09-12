package com.openclassrooms.escalade.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.model.Site;


/**
 * Classe d'implémentation de {@link SiteDao}.
 */
@Repository
public class SiteDaoImpl implements SiteDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
        
        @Transactional
	public Site getSite(int id) {
		Site site = (Site) jdbcTemplate.queryForObject("select * from site where id = ?",
				new Object[] { id }, new SiteRowMapper());
		return site;
	}

        @Transactional
	public List<Site> getAllSite() {
		List<Site> site = (List<Site>) jdbcTemplate.query("select * from site",
				new SiteRowMapper());
		return site;
	}

	@Transactional
	public int addSite(Site site) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("site").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("nom", site.getNom());
		parameters.put("description", site.getDescription());
		parameters.put("nb_secteurs", site.getNbSecteurs());
		parameters.put("ville", site.getVille());
		parameters.put("createur_id", 1);
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	@Transactional
	public int updateSite(Site site) {
		String sql = "update site set nom = ?, description = ?, nb_secteurs = ?, ville = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { site.getNom(), site.getDescription(), site.getNbSecteurs(), 
				site.getVille(), site.getId() });
		return resp;
	}

	@Transactional
	public int deleteSite(int id) {
		int resp = jdbcTemplate.update("delete from site where id = ?", id);
		return resp;
	}
}
