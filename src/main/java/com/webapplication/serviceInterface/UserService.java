package com.webapplication.serviceInterface;

import org.springframework.stereotype.Service;
import com.webapplication.classes.RegistrationForm;
import com.webapplication.entities.User;

@Service
public interface UserService {
	
	public User getUserInfo(String userName);
	public void saveUser(RegistrationForm userInfo);
	public void updateUserInfo();

}
