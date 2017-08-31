package com.webapplication.daoInterfaces;

import org.springframework.stereotype.Repository;

import com.webapplication.entities.User;

@Repository
public interface UserDaointerface {
	
	public User getUserInfo(String userName);
	public void saveUser(User userInfo);
	public void updateUserInfo();

}
