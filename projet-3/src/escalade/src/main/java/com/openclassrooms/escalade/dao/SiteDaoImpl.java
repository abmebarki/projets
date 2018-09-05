package com.openclassrooms.escalade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.openclassrooms.escalade.model.Site;

/**
 * Classe d'impl�mentation de {@link SiteDao}.
 */
@Component
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {
	  @Override
	    public List<Site> getListSite() {
	        String vSQL = "SELECT * FROM site";

	        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

	        RowMapper<Site> vRowMapper = new RowMapper<Site>() {
	            public Site mapRow(ResultSet pRS, int pRowNum) throws SQLException {
	            	Site vSite = new Site(pRS.getInt("id"));
	                vSite.setNom(pRS.getString("nom"));
	                vSite.setDescription(pRS.getString("description"));
	                vSite.setNbSecteurs(pRS.getInt("nb_secteurs"));
	                vSite.setVille(pRS.getString("ville"));
	                
	                return vSite;
	            }
	        };

	        List<Site> vListSite = vJdbcTemplate.query(vSQL, vRowMapper);

	        return vListSite;
	    }
}
