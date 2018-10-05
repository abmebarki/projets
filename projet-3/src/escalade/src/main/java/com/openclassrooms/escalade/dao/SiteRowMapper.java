package com.openclassrooms.escalade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.openclassrooms.escalade.model.Grimpeur;
import com.openclassrooms.escalade.model.Site;



public class SiteRowMapper implements RowMapper<Site> {

	public Site mapRow(ResultSet rs, int row) throws SQLException {
		Site site = new Site();
		site.setId(rs.getInt("id"));
		site.setDescription(rs.getString("description"));
		//site.setExposition(rs.getString("exposition"));
		site.setTempsApproche(rs.getInt("temps_approche"));
		//site.setSaison(rs.getString("saison"));
		site.setVille(rs.getString("ville"));
		site.setNom(rs.getString("nom"));
		site.setCreateur(new Grimpeur( rs.getInt("createur_id"))); // A VERIFIER
		return site;
	}

}
