package com.openclassrooms.escalade.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.model.Grimpeur;


/**
 * Classe d'impl�mentation de {@link GrimpeurDao}.
 */
@Repository
public class GrimpeurDaoImpl implements GrimpeurDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
        
        @Transactional
	public Grimpeur getGrimpeur(int id) {
		Grimpeur grimpeur = (Grimpeur) jdbcTemplate.queryForObject("select * from grimpeur where id = ?",
				new Object[] { id }, new GrimpeurRowMapper());
		return grimpeur;
	}

        @Transactional
	public List<Grimpeur> getAllGrimpeur() {
		List<Grimpeur> grimpeur = (List<Grimpeur>) jdbcTemplate.query("select * from grimpeur",
				new GrimpeurRowMapper());
		return grimpeur;
	}

	@Transactional
	public int addGrimpeur(Grimpeur grimpeur) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("grimpeur").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("nom", grimpeur.getNom());
		parameters.put("email", grimpeur.getEmail());
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	@Transactional
	public int updateGrimpeur(Grimpeur grimpeur) {
		String sql = "update grimpeur set nom = ?, email = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { grimpeur.getNom(), grimpeur.getEmail(), grimpeur.getId() });
		return resp;
	}

	@Transactional
	public int deleteGrimpeur(int id) {
		int resp = jdbcTemplate.update("delete from grimpeur where id = ?", id);
		return resp;
	}
}
