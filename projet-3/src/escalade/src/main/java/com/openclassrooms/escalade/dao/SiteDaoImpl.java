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
import com.openclassrooms.escalade.model.Topo;

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
	 * @see com.openclassrooms.escalade.dao.SiteDao#findByTopoId(int)
	 */
	@Override
	@Transactional
		public List<Site> findByTopoId(int topoId) {
			List<Site> sites = (List<Site>) jdbcTemplate.query("select * from site s join topo_site_descipteur tsd on s.id = tsd.site_id and tsd.topo_id = ?",
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
		parameters.put("nb_secteurs", site.getNbSecteurs());
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
		String sql = "update site set nom = ?, description = ?, ville = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { site.getNom(), site.getDescription(),
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
