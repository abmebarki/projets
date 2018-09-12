package com.openclassrooms.escalade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.openclassrooms.escalade.model.Grimpeur;
import com.openclassrooms.escalade.model.Site;



public class SiteCreateurRowMapper implements RowMapper<Site> {

	public Site mapRow(ResultSet rs, int row) throws SQLException {
		Site site = new Site();
		site.setId(rs.getInt("id"));
		site.setDescription(rs.getString("description"));
		site.setNbSecteurs(rs.getInt("nb_secteurs"));
		site.setVille(rs.getString("ville"));
		site.setNom(rs.getString("nom_site"));
		site.setCreateur(new Grimpeur( rs.getInt("createur_id"), rs.getString("nom_createur"), rs.getString("email"))); // A VERIFIER
		return site;
	}

}
