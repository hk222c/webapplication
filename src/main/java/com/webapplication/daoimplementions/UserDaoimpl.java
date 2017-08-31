package com.webapplication.daoimplementions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.webapplication.daoInterfaces.UserDaointerface;
import com.webapplication.entities.User;

import com.webapplication.dataBaseDetails.DatabaseConfig;
import com.webapplication.enmus.Roles;

@Repository
public class UserDaoimpl implements UserDaointerface {
	
	
	
	private JdbcTemplate userJdbctemplate;
	
	@Autowired
	public UserDaoimpl(DatabaseConfig configJdbctemp){
		
		this.userJdbctemplate = configJdbctemp.getJdbcTemplate();
	}
	

	public User getUserInfo(String userName) {	
		
		Map<String, Object> helperclass = null;		
		
		String sqlQuery = "select distinct * from users where firstName = ?";
		
		User userFoundorNot = new User();
		
		try {
			
			helperclass = this.userJdbctemplate.queryForMap(sqlQuery, userName);
		}catch(DataAccessException | NullPointerException e){
			
			 System.out.println("database nullpointer exception" + e);
		}
		
		if(userFoundorNot != null){
			
			userFoundorNot.setFirstName((String) helperclass.get("firstName"));
			userFoundorNot.setLastName((String) helperclass.get("lastName"));
			userFoundorNot.setPassWord((String) helperclass.get("passWords"));
			userFoundorNot.setEmail((String) helperclass.get("email"));
			userFoundorNot.setTelePhone((int) helperclass.get("telePhone"));
			String userRoles = (String) helperclass.get("roles");
			if(userRoles.equals(Roles.SIMPLEUSER)){
				userFoundorNot.setUserRole(Roles.SIMPLEUSER);
			}

		}
		
		
		return userFoundorNot;
	}

	public void saveUser(User registerUserInfo) {
		
		String sql = "INSERT INTO users (firstName, lastName, passWords, email, telePhone, roles) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			
			this.userJdbctemplate.update(sql, registerUserInfo.getFirstName(), registerUserInfo.getLastName(), registerUserInfo.getPassWord(), registerUserInfo.getEmail(), registerUserInfo.getTelePhone(), "SIMPLEUSER");
		
		}catch(DataAccessException | NullPointerException e){
			
			System.out.println("-------------------------------------------------------------------------------------------------------");
			
			System.out.println("can not create user" + e);
			
			//System.out.println(this.jdbctemplate.toString());
			
			System.out.println("-------------------------------------------------------------------------------------------------------");
		}
		
		
		
	}


	public void updateUserInfo() {
		// TODO Auto-generated method stub
		
	}

}
