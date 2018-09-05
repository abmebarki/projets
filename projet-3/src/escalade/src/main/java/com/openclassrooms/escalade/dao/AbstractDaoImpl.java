package com.openclassrooms.escalade.dao;

import java.util.List;

//import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.openclassrooms.escalade.model.Site;

public abstract class AbstractDaoImpl {
	
	@Autowired
	@Qualifier(value="dataSourceEscalade")
    private DataSource dataSource;
    
	protected DataSource getDataSource() {
        return dataSource;
    }

	public List<Site> getListSite() {
		return null;
	}

}
