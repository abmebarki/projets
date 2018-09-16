package com.openclassrooms.escalade.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.model.Commentaire;
import com.openclassrooms.escalade.model.Topo;


/**
 * Classe d'impl�mentation de {@link CommentaireDao}.
 */
@Repository
public class CommentaireDaoImpl implements CommentaireDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
        
        @Transactional
	public Commentaire findById(int id) {
		Commentaire commentaire = (Commentaire) jdbcTemplate.queryForObject("select * from commentaire where id = ?",
				new Object[] { id }, new CommentaireRowMapper());
		return commentaire;
	}

        @Transactional
	public List<Commentaire> findAll() {
		List<Commentaire> commentaire = (List<Commentaire>) jdbcTemplate.query("select * from commentaire",
				new CommentaireRowMapper());
		return commentaire;
	}

    @Transactional
	public List<Commentaire> findBySiteId(int siteId) {
		List<Commentaire> commentaire = (List<Commentaire>) jdbcTemplate.query("select * from commentaire_site cs join grimpeur g on cs.auteur_id = g.id where cs.site_commente_id = ?",
				new Object[] { siteId }, new CommentaireRowMapper());
		return commentaire;
	}        

    @Transactional
   	public List<Commentaire> findByTopoId(int topoId) {
   		List<Commentaire> commentaire = (List<Commentaire>) jdbcTemplate.query("select * from commentaire_topo ct join grimpeur g on ct.auteur_id = g.id where ct.topo_commente_id = ?",
   				new Object[] { topoId }, new CommentaireRowMapper());
   		return commentaire;
   	} 

	@Transactional
	public int save(Commentaire commentaire, int auteurId) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("commentaire").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("objet", commentaire.getObjet());
		parameters.put("contenu", commentaire.getContenu());
		parameters.put("date", commentaire.getDate());
		parameters.put("auteur_id", auteurId);
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	@Transactional
	public int update(Commentaire commentaire) {
		String sql = "update commentaire set objet = ?, contenu = ?, date = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { commentaire.getObjet(), commentaire.getContenu(), commentaire.getDate(), 
				commentaire.getId() });
		return resp;
	}

	@Transactional
	public int delete(int id) {
		int resp = jdbcTemplate.update("delete from commentaire where id = ?", id);
		return resp;
	}
}
