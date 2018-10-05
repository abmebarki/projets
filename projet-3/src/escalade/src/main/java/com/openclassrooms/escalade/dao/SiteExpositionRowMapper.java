package com.openclassrooms.escalade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.openclassrooms.escalade.model.Exposition;


public class SiteExpositionRowMapper implements RowMapper<Exposition> {

	public Exposition mapRow(ResultSet rs, int row) throws SQLException {

		return Exposition.fromValue(rs.getString("exposition"));

	}

}
