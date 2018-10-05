package com.openclassrooms.escalade.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.model.Exposition;
import com.openclassrooms.escalade.model.Saison;
import com.openclassrooms.escalade.model.Site;

/**
 * Classe d'implémentation de {@link SiteDao}.
 */
@Repository
public class SiteDaoImpl implements SiteDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.dao.SiteDao#findById(int)
	 */
	@Override
	@Transactional
	public Site findById(int id) {
		Site site = (Site) jdbcTemplate.queryForObject("select * from site where id = ?", new Object[] { id }, new SiteRowMapper());
		return site;
	}

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.dao.SiteDao#findAll()
	 */
	@Override
	@Transactional
	public List<Site> findAll() {
		List<Site> site = (List<Site>) jdbcTemplate.query("select * from site", new SiteRowMapper());
		return site;
	}
	
	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.dao.SiteDao#findAll()
	 */
	@Override
	@Transactional
	public List<Site> findAll(int createurId) {
		List<Site> site = (List<Site>) jdbcTemplate.query("select * from site where createur_id = ?", new Object[] { createurId }, new SiteRowMapper());
		return site;
	}
	
	
	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.dao.SiteDao#findAll()
	 */
	@Override
	@Transactional
	public List<Site> findAll(Site site) {
		 
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		
		Set<String> expositions = new HashSet<String>(); 
		Set<String> saisons = new HashSet<String>();
			
		for(Exposition exposition: site.getExpositions() ) {
			expositions.add(exposition.value());
		}
		
		for(Saison saison: site.getSaisons() ) {
			saisons.add(saison.value());
		}
		
		sql = sql.append("select distinct s.* from site s join secteur se on s.id = se.site_id join site_exposition sx on s.id = sx.site_id join site_saison ss on s.id = ss.site_id where true");
		
		if(!site.getVille().toUpperCase().isEmpty()) {
			parameters.addValue("ville", site.getVille().toUpperCase());
			sql = sql.append(" and upper(ville) = :ville");
		}
		
		if(site.getTempsApproche() != null) {
			parameters.addValue("tempsApproche", site.getTempsApproche());
			sql = sql.append(" and s.temps_approche >= :tempsApproche");
		}
		
		if(!site.getSecteurs().get(0).getType().isEmpty()) {
			parameters.addValue("type", site.getSecteurs().get(0).getType());
			sql = sql.append(" and se.type <= :type");
		}
		
		if(!site.getSecteurs().get(0).getDifficulte().isEmpty()) {
			parameters.addValue("type", site.getSecteurs().get(0).getDifficulte());
			sql = sql.append(" and se.difficulte = :difficulte");
		}
		 
		if(!expositions.isEmpty()) {
			parameters.addValue("expositions", expositions);
			sql = sql.append(" and sx.exposition in (:expositions)");
		}
		
		if(!saisons.isEmpty()) {
			parameters.addValue("saisons", saisons);
			sql = sql.append(" and ss.saison in (:saisons)");
		}
		
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
		List<Site> rsite = (List<Site>) namedParameterJdbcTemplate.query(sql.toString(), parameters ,  new SiteRowMapper());
		return rsite;
	}
	
	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.dao.SiteDao#findByTopoId(int)
	 */
	@Override
	@Transactional
		public List<Site> findByTopoId(int topoId) {
			List<Site> sites = (List<Site>) jdbcTemplate.query("select * from site s join topo_site_descripteur tsd on s.id = tsd.site_id and tsd.topo_id = ?",
					new Object[] { topoId }, new SiteRowMapper());
			return sites;
	}  

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.dao.SiteDao#create(com.openclassrooms.escalade.model.Site)
	 */
	@Override
	@Transactional
	public int create(Site site) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("site").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("nom", site.getNom());
		parameters.put("description", site.getDescription());
		//parameters.put("exposition", site.getExposition());
		parameters.put("temps_approche", site.getTempsApproche());
		//parameters.put("saison", site.getSaison());
		parameters.put("ville", site.getVille());
		parameters.put("createur_id", site.getCreateur().getId());
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.dao.SiteDao#update(com.openclassrooms.escalade.model.Site)
	 */
	@Override
	@Transactional
	public int update(Site site) {
		String sql = "update site set nom = ?, description = ?, temps_approche = ?, ville = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { site.getNom(), site.getDescription(), site.getTempsApproche(),
				site.getVille(), site.getId() });
		return resp;
	}

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.dao.SiteDao#delete(int)
	 */
	@Override
	@Transactional
	public int delete(int id) {
		int resp = jdbcTemplate.update("delete from site where id = ?", id);
		return resp;
	}
}
