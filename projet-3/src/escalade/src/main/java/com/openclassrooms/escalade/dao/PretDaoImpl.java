package com.openclassrooms.escalade.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.model.Pret;


/**
 * Classe d'implémentation de {@link PretDao}.
 */
@Repository
public class PretDaoImpl implements PretDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
        
        @Transactional
	public Pret findById(int id) {
		Pret pret = (Pret) jdbcTemplate.queryForObject("select * from pret where id = ?",
				new Object[] { id }, new PretRowMapper());
		return pret;
	}

        @Transactional
	public List<Pret> findAll() {
		List<Pret> pret = (List<Pret>) jdbcTemplate.query("select * from pret",	new PretRowMapper());
		return pret;
	}

	@Transactional
	public int create(Pret pret) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("pret");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("emprunteur_id", 16);
		parameters.put("topo_id", 10);
		parameters.put("date_debut", pret.getDateDebut());
		parameters.put("date_fin", pret.getDateFin());
		Number insertedId = simpleJdbcInsert.execute(parameters);
		return insertedId.intValue();
	}

	@Transactional
	public int update(Pret pret) {
		String sql = "update pret set date_debut = ?, date_fin = ? where emprunteur_id = ? and topo_id =?";
		int resp = jdbcTemplate.update(sql, new Object[] { pret.getDateDebut(), pret.getDateFin(), pret.getEmprunteur().getId(), 
				pret.getTopoEmprunte().getId() });
		return resp;
	}

	@Transactional
	public int delete(int id) {
		int resp = jdbcTemplate.update("delete from pret where id = ?", id);
		return resp;
	}
}
