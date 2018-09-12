package com.openclassrooms.escalade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.openclassrooms.escalade.model.Grimpeur;



public class GrimpeurRowMapper implements RowMapper<Grimpeur> {

	public Grimpeur mapRow(ResultSet rs, int row) throws SQLException {
		Grimpeur grimpeur = new Grimpeur();
		grimpeur.setId(rs.getInt("id"));
		grimpeur.setNom(rs.getString("nom"));
		grimpeur.setEmail(rs.getString("email"));
		
		return grimpeur;
	}

}