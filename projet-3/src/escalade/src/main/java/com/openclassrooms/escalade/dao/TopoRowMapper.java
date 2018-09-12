package com.openclassrooms.escalade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.openclassrooms.escalade.model.Topo;



public class TopoRowMapper implements RowMapper<Topo> {

	public Topo mapRow(ResultSet rs, int row) throws SQLException {
		Topo topo = new Topo();
		topo.setId(rs.getInt("id"));
		topo.setNom(rs.getString("nom"));
		topo.setNbPages(rs.getInt("nb_pages"));
		topo.setAuteur(rs.getString("auteur"));
		topo.setDate(rs.getDate("date"));
		return topo;
	}

}
