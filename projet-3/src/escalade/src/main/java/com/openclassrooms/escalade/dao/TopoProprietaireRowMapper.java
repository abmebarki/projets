package com.openclassrooms.escalade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.openclassrooms.escalade.model.Grimpeur;
import com.openclassrooms.escalade.model.Topo;



public class TopoProprietaireRowMapper implements RowMapper<Topo> {

	public Topo mapRow(ResultSet rs, int row) throws SQLException {
		Topo topo = new Topo();
		topo.setId(rs.getInt("id"));
		topo.setNom(rs.getString("nom_topo"));
		topo.setNbPages(rs.getInt("nb_pages"));
		topo.setAuteur(rs.getString("auteur"));
		topo.setDate(rs.getDate("date"));
		topo.setProprietaire(new Grimpeur( rs.getInt("proprietaire_id"), rs.getString("nom_proprietaire"), rs.getString("email_proprietaire"))); // A VERIFIER
		
		return topo;
	}

}
