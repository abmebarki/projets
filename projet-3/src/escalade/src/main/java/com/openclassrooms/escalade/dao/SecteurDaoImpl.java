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


/**
 * Classe d'impl�mentation de {@link SecteurDao}.
 */
@Repository
public class SecteurDaoImpl implements SecteurDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
        
        @Transactional
	public Secteur getSecteur(int id) {
		Secteur secteur = (Secteur) jdbcTemplate.queryForObject("select * from secteur where id = ?",
				new Object[] { id }, new SecteurRowMapper());
		return secteur;
	}

        @Transactional
	public List<Secteur> getAllSecteur() {
		List<Secteur> secteurs = (List<Secteur>) jdbcTemplate.query("select * from secteur",
				new SecteurRowMapper());
		return secteurs;
	}
        
    @Transactional
	public List<Secteur> getSecteurs(int siteID) {
		List<Secteur> secteurs = (List<Secteur>) jdbcTemplate.query("select * from secteur where site_id = ?",
				new Object[] { siteID }, new SecteurRowMapper());
		return secteurs;
	}    

	@Transactional
	public int addSecteur(Secteur secteur) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("secteur").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("nom", secteur.getNom());
		parameters.put("description", secteur.getDescription());
		parameters.put("hauteur_max", secteur.getHauteurMax());
		parameters.put("coordonnees", secteur.getCoordonnees());
		parameters.put("nb_voies", secteur.getNbVoies());
		parameters.put("orientation", secteur.getOrientation());
		//parameters.put(key,)
		
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	@Transactional
	public int updateSecteur(Secteur secteur) {
		String sql = "update secteur set nom = ?, description = ?, hauteur_max = ?, coordonnees = ?, nb_voies = ?, orientation = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { secteur.getNom(), secteur.getDescription(), secteur.getHauteurMax(), secteur.getCoordonnees(), secteur.getNbVoies(), 
				secteur.getOrientation(), secteur.getId() });
		return resp;
	}

	@Transactional
	public int deleteSecteur(int id) {
		int resp = jdbcTemplate.update("delete from secteur where id = ?", id);
		return resp;
	}
}
