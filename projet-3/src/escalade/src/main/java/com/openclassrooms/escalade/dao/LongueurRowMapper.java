package com.openclassrooms.escalade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.openclassrooms.escalade.model.Longueur;



public class LongueurRowMapper implements RowMapper<Longueur> {

	public Longueur mapRow(ResultSet rs, int row) throws SQLException {
		Longueur longueur = new Longueur();
		longueur.setId(rs.getInt("id"));
		longueur.setCotation(rs.getString("cotation"));
		longueur.setHauteur(rs.getInt("hauteur"));
		longueur.setNbPoints(rs.getInt("nb_points"));
		longueur.setEquipee(rs.getBoolean("equipee"));
		
		return longueur;
	}

}
