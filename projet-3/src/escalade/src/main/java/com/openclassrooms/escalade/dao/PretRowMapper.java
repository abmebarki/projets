package com.openclassrooms.escalade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.openclassrooms.escalade.model.Grimpeur;
import com.openclassrooms.escalade.model.Pret;
import com.openclassrooms.escalade.model.Topo;



public class PretRowMapper implements RowMapper<Pret> {

	public Pret mapRow(ResultSet rs, int row) throws SQLException {
		Pret pret = new Pret();
		pret.setId(rs.getInt("id"));
		pret.setEmprunteur(new Grimpeur(rs.getInt("emprunteur_id")));
		pret.setTopoEmprunte(new Topo(rs.getInt("topo_id")));
		pret.setDateDebut(rs.getDate("date_debut"));
		pret.setDateFin(rs.getDate("date_fin"));
		
		return pret;
	}

}
