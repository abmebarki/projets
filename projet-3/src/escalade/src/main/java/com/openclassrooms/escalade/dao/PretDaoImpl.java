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
 * Classe d'impl�mentation de {@link PretDao}.
 */
@Repository
public class PretDaoImpl implements PretDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
        
        @Transactional
	public Pret getPret(int id) {
		Pret pret = (Pret) jdbcTemplate.queryForObject("select * from pret where id = ?",
				new Object[] { id }, new PretRowMapper());
		return pret;
	}

        @Transactional
	public List<Pret> getAllPret() {
		List<Pret> pret = (List<Pret>) jdbcTemplate.query("select * from pret",
				new PretRowMapper());
		return pret;
	}

	@Transactional
	public int addPret(Pret pret) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		//simpleJdbcInsert.withTableName("pret").usingGeneratedKeyColumns("id");
		simpleJdbcInsert.withTableName("pret");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("emprunteur_id", 1);
		parameters.put("topo_id", 1);
		parameters.put("date_debut", pret.getDateDebut());
		parameters.put("date_fin", pret.getDateFin());
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	@Transactional
	public int updatePret(Pret pret) {
		String sql = "update pret set date_debut = ?, date_fin = ? where emprunteur_id = ? and topo_id =?";
		int resp = jdbcTemplate.update(sql, new Object[] { pret.getDateDebut(), pret.getDateFin(), pret.getEmprunteur().getId(), 
				pret.getTopoPrete().getId() });
		return resp;
	}

	@Transactional
	public int deletePret(int id) {
		int resp = jdbcTemplate.update("delete from pret where id = ?", id);
		return resp;
	}
}