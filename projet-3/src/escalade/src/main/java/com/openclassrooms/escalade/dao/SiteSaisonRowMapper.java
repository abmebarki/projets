package com.openclassrooms.escalade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.openclassrooms.escalade.model.Saison;


public class SiteSaisonRowMapper implements RowMapper<Saison> {

	public Saison mapRow(ResultSet rs, int row) throws SQLException {

		return Saison.fromValue(rs.getString("saison"));

	}

}
