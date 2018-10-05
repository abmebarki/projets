package com.openclassrooms.escalade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.openclassrooms.escalade.model.Secteur;



public class SecteurRowMapper implements RowMapper<Secteur> {

	public Secteur mapRow(ResultSet rs, int row) throws SQLException {
		
		Secteur secteur = new Secteur();
		secteur.setId(rs.getInt("id"));
		secteur.setNom(rs.getString("nom"));
		secteur.setDescription(rs.getString("description"));
		secteur.setType(rs.getString("type"));
		secteur.setDifficulte(rs.getString("difficulte"));
		secteur.setHauteurMax(rs.getInt("hauteur_max"));
		secteur.setCoordonnees(rs.getString("coordonnees"));
		
		return secteur;
	}

}
