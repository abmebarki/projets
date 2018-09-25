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
 * Classe d'implémentation de {@link CommentaireDao}.
 */
@Repository
public class CommentaireDaoImpl implements CommentaireDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
        
    @Transactional
	public Commentaire findByIdForSite(int id) {
		Commentaire commentaire = (Commentaire) jdbcTemplate.queryForObject("select * from commentaire_site cs join grimpeur g on cs.auteur_id = g.id where cs.id = ?",
				new Object[] { id }, new CommentaireRowMapper());
		return commentaire;
	}
    
    @Transactional
	public Commentaire findByIdForTopo(int id) {
		Commentaire commentaire = (Commentaire) jdbcTemplate.queryForObject("select * from commentaire_topo ct join grimpeur g on ct.auteur_id = g.id where ct.id = ?",
				new Object[] { id }, new CommentaireRowMapper());
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
	public int createBySite(Commentaire commentaire, int siteId) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("commentaire_site").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("objet", commentaire.getObjet());
		parameters.put("contenu", commentaire.getContenu());
		parameters.put("date", commentaire.getDate());
		parameters.put("auteur_id", commentaire.getAuteur().getId());
		parameters.put("site_commente_id", siteId);
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	@Transactional
	public int updateBySite(Commentaire commentaire) {
		String sql = "update commentaire_site set objet = ?, contenu = ?, date = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { commentaire.getObjet(), commentaire.getContenu(), commentaire.getDate(), 
				commentaire.getId() });
		return resp;
	}

	@Transactional
	public int deleteBySite(int id) {
		int resp = jdbcTemplate.update("delete from commentaire_site where id = ?", id);
		return resp;
	}
	
	@Transactional
	public int createByTopo(Commentaire commentaire, int topoId) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("commentaire_topo").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("objet", commentaire.getObjet());
		parameters.put("contenu", commentaire.getContenu());
		parameters.put("date", commentaire.getDate());
		parameters.put("auteur_id", commentaire.getAuteur().getId());
		parameters.put("topo_commente_id", topoId);
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	@Transactional
	public int updateByTopo(Commentaire commentaire) {
		String sql = "update commentaire_topo set objet = ?, contenu = ?, date = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { commentaire.getObjet(), commentaire.getContenu(), commentaire.getDate(), 
				commentaire.getId() });
		return resp;
	}

	@Transactional
	public int deleteByTopo(int id) {
		int resp = jdbcTemplate.update("delete from commentaire_topo where id = ?", id);
		return resp;
	}
}
