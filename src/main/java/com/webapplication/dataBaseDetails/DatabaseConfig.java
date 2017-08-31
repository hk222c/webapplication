package com.webapplication.dataBaseDetails;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class DatabaseConfig {	
	
	
	private JdbcTemplate jdbcTemplate;
	

	@Autowired	
	public void setDataSource(DataSource dataSource){
		
		this.jdbcTemplate = new JdbcTemplate(dataSource);		
		
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

}
