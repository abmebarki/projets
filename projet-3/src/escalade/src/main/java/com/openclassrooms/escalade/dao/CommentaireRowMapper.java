package com.openclassrooms.escalade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.openclassrooms.escalade.model.Commentaire;
import com.openclassrooms.escalade.model.Grimpeur;



public class CommentaireRowMapper implements RowMapper<Commentaire> {

	public Commentaire mapRow(ResultSet rs, int row) throws SQLException {
		Commentaire commentaire = new Commentaire();
		commentaire.setId(rs.getInt("id"));
		commentaire.setObjet(rs.getString("objet"));
		commentaire.setContenu(rs.getString("contenu"));
		commentaire.setDate(rs.getDate("date"));
		commentaire.setAuteur(new Grimpeur(rs.getInt("auteur_id"), rs.getString("nom"), rs.getString("email")));
		
		return commentaire;
	}

}
