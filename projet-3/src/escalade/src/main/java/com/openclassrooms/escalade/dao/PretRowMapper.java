package com.openclassrooms.escalade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.openclassrooms.escalade.model.Grimpeur;
import com.openclassrooms.escalade.model.Pret;



public class PretRowMapper implements RowMapper<Pret> {

	public Pret mapRow(ResultSet rs, int row) throws SQLException {
		Pret pret = new Pret();
		pret.setEmprunteur(new Grimpeur(1));
		pret.setDateDebut(rs.getDate("date_debut"));
		pret.setDateFin(rs.getDate("date_fin"));
		
		return pret;
	}

}
