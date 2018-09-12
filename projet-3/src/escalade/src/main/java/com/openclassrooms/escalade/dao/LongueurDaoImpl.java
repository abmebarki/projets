package com.openclassrooms.escalade.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.model.Longueur;
import com.openclassrooms.escalade.model.Voie;


/**
 * Classe d'impl�mentation de {@link LongueurDao}.
 */
@Repository
public class LongueurDaoImpl implements LongueurDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
        
        @Transactional
	public Longueur getLongueur(int id) {
		Longueur longueur = (Longueur) jdbcTemplate.queryForObject("select * from longueur where id = ?",
				new Object[] { id }, new LongueurRowMapper());
		return longueur;
	}

        @Transactional
	public List<Longueur> getAllLongueur() {
		List<Longueur> longueur = (List<Longueur>) jdbcTemplate.query("select * from longueur",
				new LongueurRowMapper());
		return longueur;
	}
    
    @Transactional
	public List<Longueur> getLongueurs(int voieID) {
		List<Longueur> longueurs = (List<Longueur>) jdbcTemplate.query("select * from longueur where voie_id = ?",
				new Object[] { voieID }, new LongueurRowMapper());
		return longueurs;
	}          

	@Transactional
	public int addLongueur(Longueur longueur) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("longueur").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("cotation", longueur.getCotation());
		parameters.put("hauteur", longueur.getHauteur());
		parameters.put("nb_points", longueur.getNbPoints());
		parameters.put("equipee", longueur.isEquipee());
		parameters.put("voie_id", 1);
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	@Transactional
	public int updateLongueur(Longueur longueur) {
		String sql = "update longueur set cotation = ?, hauteur = ?, nb_points = ?, equipee = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { longueur.getCotation(), longueur.getHauteur(), longueur.getNbPoints(), 
				longueur.isEquipee(), longueur.getId() });
		return resp;
	}

	@Transactional
	public int deleteLongueur(int id) {
		int resp = jdbcTemplate.update("delete from longueur where id = ?", id);
		return resp;
	}
}
