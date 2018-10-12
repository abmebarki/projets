package com.openclassrooms.escalade.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.model.Grimpeur;


/**
 * Classe d'implémentation de {@link GrimpeurDao}.
 */
@Repository
public class GrimpeurDaoImpl implements GrimpeurDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
        
	@Override
    @Transactional
	public Grimpeur findById(int id) {
		Grimpeur grimpeur = (Grimpeur) jdbcTemplate.queryForObject("select * from grimpeur where id = ?",
				new Object[] { id }, new GrimpeurRowMapper());
		return grimpeur;
	}
    
	@Override
    @Transactional
    public Grimpeur findByIdEmailPassword(String email, String password)  {
       	try {
       		Grimpeur utilisateur = (Grimpeur) jdbcTemplate.queryForObject("select * from grimpeur where upper(email) = ? and upper(mot_passe)= ?",
   				new Object[] { email.toUpperCase(), password.toUpperCase() }, new GrimpeurRowMapper());
   		
       		return utilisateur;
   		
       	} catch (EmptyResultDataAccessException e) {
       		
       		return null;
       		
       	}
   	}
    
	@Override
    @Transactional
	public Grimpeur findByNameEmail(String name, String email) {
		Grimpeur grimpeur = (Grimpeur) jdbcTemplate.queryForObject("select * from grimpeur where upper(nom) = ? and upper(email)= ? limit 1",
				new Object[] { name.toUpperCase(), email.toUpperCase() }, new GrimpeurRowMapper());
		return grimpeur;
	}

        
        
	@Override    
    @Transactional
	public List<Grimpeur> findAll() {
		List<Grimpeur> grimpeur = (List<Grimpeur>) jdbcTemplate.query("select * from grimpeur",	new GrimpeurRowMapper());
		return grimpeur;
	}

	@Override
	@Transactional
	public int create(Grimpeur grimpeur) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("grimpeur").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("nom", grimpeur.getNom());
		parameters.put("email", grimpeur.getEmail());
		parameters.put("role", grimpeur.getRole().value());
		parameters.put("mot_passe",grimpeur.getMotpasse());
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	@Override
	@Transactional
	public int update(Grimpeur grimpeur) {
		String sql = "update grimpeur set nom = ?, email = ?, role = ?, mot_passe = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { grimpeur.getNom(), grimpeur.getEmail(), grimpeur.getRole().value(), grimpeur.getMotpasse(), grimpeur.getId() });
		return resp;
	}

	@Override
	@Transactional
	public int delete(int id) {
		int resp = jdbcTemplate.update("delete from grimpeur where id = ?", id);
		return resp;
	}
}
