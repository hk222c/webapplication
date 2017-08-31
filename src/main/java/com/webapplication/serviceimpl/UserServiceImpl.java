package com.webapplication.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapplication.classes.RegistrationForm;
import com.webapplication.daoInterfaces.UserDaointerface;
import com.webapplication.entities.User;
import com.webapplication.serviceInterface.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDaointerface userDao;
	

	public User getUserInfo(String userName) {
		
		User userInfo = null;
		
		User userInfo1 = null;
		
		try{
		
			userInfo = userDao.getUserInfo(userName);
			
		} catch(Exception e){
			
			
		}		
		
		userInfo1 = userInfo;
		
		return userInfo;
	}

	public void saveUser(RegistrationForm userInfo) {
		
		User newUserInfo = registrationToUser(userInfo);
		userDao.saveUser(newUserInfo);
		
	}

	public void updateUserInfo() {
		
		
	}
	
	private User registrationToUser(RegistrationForm userInfo){
		
		User toUser = new User();
		toUser.setFirstName(userInfo.getFirstName());
		toUser.setLastName(userInfo.getLastName());
		toUser.setPassWord(userInfo.getPassWord());
		toUser.setEmail(userInfo.getEmail());
		toUser.setTelePhone(userInfo.getTelePhone());
		return toUser;
	}

}
