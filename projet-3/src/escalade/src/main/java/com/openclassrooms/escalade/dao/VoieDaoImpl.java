package com.openclassrooms.escalade.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.model.Secteur;
import com.openclassrooms.escalade.model.Voie;


/**
 * Classe d'implémentation de {@link VoieDao}.
 */
@Repository
public class VoieDaoImpl implements VoieDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
        
        @Transactional
	public Voie findById(int id) {
		Voie voie = (Voie) jdbcTemplate.queryForObject("select * from voie where id = ?",
				new Object[] { id }, new VoieRowMapper());
		return voie;
	}

        @Transactional
	public List<Voie> findAll() {
		List<Voie> voie = (List<Voie>) jdbcTemplate.query("select * from voie",
				new VoieRowMapper());
		return voie;
	}
        
    @Transactional
	public List<Voie> findBySecteurId(int secteurId) {
		List<Voie> voies = (List<Voie>) jdbcTemplate.query("select * from voie where secteur_id = ?",
				new Object[] { secteurId }, new VoieRowMapper());
		return voies;
	}          

	@Transactional
	public int create(Voie voie, int secteurId) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("voie").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("nom", voie.getNom());
		parameters.put("nb_longueurs", voie.getNbLongueurs());
		parameters.put("secteur_id", secteurId);
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	@Transactional
	public int update(Voie voie) {
		String sql = "update voie set nom = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { voie.getNom(), voie.getId() });
		return resp;
	}

	@Transactional
	public int delete(int id) {
		int resp = jdbcTemplate.update("delete from voie where id = ?", id);
		return resp;
	}
}
