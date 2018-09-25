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
import com.openclassrooms.escalade.model.Topo;


/**
 * Classe d'implémentation de {@link GrimpeurDao}.
 */
@Repository
public class GrimpeurTopoProprietaireDaoImpl implements GrimpeurTopoProprietaireDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
        
	@Transactional
	public int create(Topo topo) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("grimpeur_topo_proprietaire");
		Map<String, Object> parameters = new HashMap<String, Object>(2);
		parameters.put("proprietaire_id", topo.getProprietaire().getId());
		parameters.put("topo_id", topo.getId());
		Number insertedId = simpleJdbcInsert.execute(parameters);
		return insertedId.intValue();
	}

}
