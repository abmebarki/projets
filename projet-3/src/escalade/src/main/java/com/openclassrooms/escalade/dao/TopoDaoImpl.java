package com.openclassrooms.escalade.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.model.Topo;


/**
 * Classe d'impl�mentation de {@link TopoDao}.
 */
@Repository
public class TopoDaoImpl implements TopoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
        
        /* (non-Javadoc)
		 * @see com.openclassrooms.escalade.dao.TopoDao#findById(int)
		 */
        @Override
		@Transactional
	public Topo findById(int id) {
		Topo topo = (Topo) jdbcTemplate.queryForObject("select t.id, t.nom as nom_topo, t.nb_pages, t.date, t.auteur, t.createur_id, gc.nom as nom_createur, gc.email as email_createur, gp.id proprietaire_id, gp.nom as nom_proprietaire, gp.email as email_proprietaire from topo t join grimpeur gc on t.createur_id = gc.id and t.id = ?  left join grimpeur_topo_proprietaire gtp on t.id = gtp.topo_id left join grimpeur gp on gp.id = gtp.proprietaire_id",
				new Object[] { id }, new TopoCreateurProprietaireRowMapper());
		return topo;
	}

        /* (non-Javadoc)
		 * @see com.openclassrooms.escalade.dao.TopoDao#findAll()
		 */
        @Override
		@Transactional
	public List<Topo> findAll() {
		List<Topo> topo = (List<Topo>) jdbcTemplate.query("select * from topo",
				new TopoRowMapper());
		return topo;
	}
        
    /* (non-Javadoc)
	 * @see com.openclassrooms.escalade.dao.TopoDao#findBySiteId(int)
	 */
    @Override
	@Transactional
	public List<Topo> findBySiteId(int siteId) {
		List<Topo> topos = (List<Topo>) jdbcTemplate.query("select * from topo t join topo_site_descipteur tsd on t.id = tsd.topo_id where tsd.site_id = ?",
				new Object[] { siteId }, new TopoRowMapper());
		return topos;
	}        

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.dao.TopoDao#save(com.openclassrooms.escalade.model.Topo)
	 */
	@Override
	@Transactional
	public int save(Topo topo) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("topo").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("nom", topo.getNom());
		parameters.put("nb_pages", topo.getNbPages());
		parameters.put("auteur", topo.getAuteur());
		parameters.put("date", topo.getDate());
		parameters.put("createur_id", 1);
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.dao.TopoDao#update(com.openclassrooms.escalade.model.Topo)
	 */
	@Override
	@Transactional
	public int update(Topo topo) {
		String sql = "update topo set nom = ?, nb_pages = ?, auteur = ?, date = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { topo.getNom(), topo.getNbPages(), topo.getAuteur(), 
				topo.getDate(), topo.getId() });
		return resp;
	}

	/* (non-Javadoc)
	 * @see com.openclassrooms.escalade.dao.TopoDao#delete(int)
	 */
	@Override
	@Transactional
	public int delete(int id) {
		int resp = jdbcTemplate.update("delete from topo where id = ?", id);
		return resp;
	}
}
