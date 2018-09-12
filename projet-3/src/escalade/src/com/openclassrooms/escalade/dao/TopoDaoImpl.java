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
 * Classe d'implémentation de {@link TopoDao}.
 */
@Repository
public class TopoDaoImpl implements TopoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
        
        @Transactional
	public Topo getTopo(int id) {
		Topo topo = (Topo) jdbcTemplate.queryForObject("select * from topo where id = ?",
				new Object[] { id }, new TopoRowMapper());
		return topo;
	}

        @Transactional
	public List<Topo> getAllTopo() {
		List<Topo> topo = (List<Topo>) jdbcTemplate.query("select * from topo",
				new TopoRowMapper());
		return topo;
	}

	@Transactional
	public int addTopo(Topo topo) {
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

	@Transactional
	public int updateTopo(Topo topo) {
		String sql = "update topo set nom = ?, nb_pages = ?, auteur = ?, date = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { topo.getNom(), topo.getNbPages(), topo.getAuteur(), 
				topo.getDate(), topo.getId() });
		return resp;
	}

	@Transactional
	public int deleteTopo(int id) {
		int resp = jdbcTemplate.update("delete from topo where id = ?", id);
		return resp;
	}
}
