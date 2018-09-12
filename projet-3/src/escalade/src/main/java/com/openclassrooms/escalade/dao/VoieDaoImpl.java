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
 * Classe d'impl�mentation de {@link VoieDao}.
 */
@Repository
public class VoieDaoImpl implements VoieDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
        
        @Transactional
	public Voie getVoie(int id) {
		Voie voie = (Voie) jdbcTemplate.queryForObject("select * from voie where id = ?",
				new Object[] { id }, new VoieRowMapper());
		return voie;
	}

        @Transactional
	public List<Voie> getAllVoie() {
		List<Voie> voie = (List<Voie>) jdbcTemplate.query("select * from voie",
				new VoieRowMapper());
		return voie;
	}
        
    @Transactional
	public List<Voie> getVoies(int secteurID) {
		List<Voie> voies = (List<Voie>) jdbcTemplate.query("select * from voie where secteur_id = ?",
				new Object[] { secteurID }, new VoieRowMapper());
		return voies;
	}          

	@Transactional
	public int addVoie(Voie voie) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("voie").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("nom", voie.getNom());
		parameters.put("nb_longueur", voie.getNbLongueurs());
		parameters.put("secteur_id", 1);
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	@Transactional
	public int updateVoie(Voie voie) {
		String sql = "update voie set nom = ?, nb_longueur = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { voie.getNom(), voie.getNbLongueurs(), voie.getId() });
		return resp;
	}

	@Transactional
	public int deleteVoie(int id) {
		int resp = jdbcTemplate.update("delete from voie where id = ?", id);
		return resp;
	}
}
