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
    
	@Override
    @Transactional
	public Pret findById(int id) {
		Pret pret = (Pret) jdbcTemplate.queryForObject("select * from pret where id = ?",
				new Object[] {id}, new PretRowMapper());
		return pret;
	}

	@Override
    @Transactional
	public List<Pret> findAll() {
		List<Pret> pret = (List<Pret>) jdbcTemplate.query("select * from pret",	new PretRowMapper());
		return pret;
	}
    
	@Override
    @Transactional
	public List<Pret> findAll(int emprunteurId) {
		List<Pret> pret = (List<Pret>) jdbcTemplate.query("select * from pret where emprunteur_id = ?",	new Object[] {emprunteurId}, new PretRowMapper());
		return pret;
	}
	
	@Override
	@Transactional
    public List<Pret> findByTopoIdDates(Pret pret) {
		List<Pret> rpret = (List<Pret>) jdbcTemplate.query("select * from pret where topo_id = ? and (date_debut, date_fin) overlaps (?, ?)", 
				new Object[] {pret.getTopoEmprunte().getId(), pret.getDateDebut(), pret.getDateFin()} ,new PretRowMapper());
		return rpret;
	}

	@Override
	@Transactional
	public int create(Pret pret) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("pret").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("emprunteur_id", pret.getEmprunteur().getId());
		parameters.put("topo_id", pret.getTopoEmprunte().getId());
		parameters.put("date_debut", pret.getDateDebut());
		parameters.put("date_fin", pret.getDateFin());
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	@Override
	@Transactional
	public int update(Pret pret) {
		String sql = "update pret set date_debut = ?, date_fin = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { pret.getDateDebut(), pret.getDateFin(), pret.getId() });
		return resp;
	}

	@Override
	@Transactional
	public int delete(int id) {
		int resp = jdbcTemplate.update("delete from pret where id = ?", id);
		return resp;
	}
}
