package com.openclassrooms.escalade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.openclassrooms.escalade.model.Voie;



public class VoieRowMapper implements RowMapper<Voie> {

	public Voie mapRow(ResultSet rs, int row) throws SQLException {
		Voie voie = new Voie();
		voie.setId(rs.getInt("id"));
		voie.setNbLongueurs(rs.getInt("nb_longueurs"));
		voie.setNom(rs.getString("nom"));
		
		return voie;
	}

}
