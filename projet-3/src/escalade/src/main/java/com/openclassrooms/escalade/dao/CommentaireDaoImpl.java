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
	public Commentaire getCommentaire(int id) {
		Commentaire commentaire = (Commentaire) jdbcTemplate.queryForObject("select * from commentaire where id = ?",
				new Object[] { id }, new CommentaireRowMapper());
		return commentaire;
	}

        @Transactional
	public List<Commentaire> getAllCommentaire() {
		List<Commentaire> commentaire = (List<Commentaire>) jdbcTemplate.query("select * from commentaire",
				new CommentaireRowMapper());
		return commentaire;
	}

    @Transactional
	public List<Commentaire> getCommentairesSite(int siteID) {
		List<Commentaire> commentaire = (List<Commentaire>) jdbcTemplate.query("select * from commentaire_site cs, grimpeur g where cs.auteur_id = g.id and cs.site_commente_id = ?",
				new Object[] { siteID }, new CommentaireRowMapper());
		return commentaire;
	}        
        

	@Transactional
	public int addCommentaire(Commentaire commentaire) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("commentaire").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("objet", commentaire.getObjet());
		parameters.put("contenu", commentaire.getContenu());
		parameters.put("date", commentaire.getDate());
		parameters.put("auteur_id", 1);
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	@Transactional
	public int updateCommentaire(Commentaire commentaire) {
		String sql = "update commentaire set objet = ?, contenu = ?, date = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { commentaire.getObjet(), commentaire.getContenu(), commentaire.getDate(), 
				commentaire.getId() });
		return resp;
	}

	@Transactional
	public int deleteCommentaire(int id) {
		int resp = jdbcTemplate.update("delete from commentaire where id = ?", id);
		return resp;
	}
}
