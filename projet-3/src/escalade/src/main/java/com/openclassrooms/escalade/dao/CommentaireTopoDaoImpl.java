package com.openclassrooms.escalade.dao;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.model.Commentaire;



/**
 * Classe d'implémentation de {@link CommentaireSiteDao}.
 */
@Repository
public class CommentaireTopoDaoImpl implements CommentaireTopoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
        
	@Override
    @Transactional
	public Commentaire findById(int id) {
		Commentaire commentaire = (Commentaire) jdbcTemplate.queryForObject("select * from commentaire_topo ct join grimpeur g on ct.auteur_id = g.id where ct.id = ?",
				new Object[] { id }, new CommentaireRowMapper());
		return commentaire;
	}

	@Override
    @Transactional
   	public List<Commentaire> findByTopoId(int topoId) {
   		List<Commentaire> commentaire = (List<Commentaire>) jdbcTemplate.query("select * from commentaire_topo ct join grimpeur g on ct.auteur_id = g.id where ct.topo_commente_id = ?",
   				new Object[] { topoId }, new CommentaireRowMapper());
   		return commentaire;
   	} 

	@Override
	@Transactional
	public int create(Commentaire commentaire, int topoId) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("commentaire_topo").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("objet", commentaire.getObjet());
		parameters.put("contenu", commentaire.getContenu());
		parameters.put("date", new Date());
		parameters.put("auteur_id", commentaire.getAuteur().getId());
		parameters.put("topo_commente_id", topoId);
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	@Override
	@Transactional
	public int update(Commentaire commentaire) {
		String sql = "update commentaire_topo set objet = ?, contenu = ?, date = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { commentaire.getObjet(), commentaire.getContenu(), commentaire.getDate(), 
				commentaire.getId() });
		return resp;
	}

	@Override
	@Transactional
	public int delete(int id) {
		int resp = jdbcTemplate.update("delete from commentaire_topo where id = ?", id);
		return resp;
	}
}
