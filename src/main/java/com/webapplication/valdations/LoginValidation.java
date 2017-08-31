package com.webapplication.valdations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.webapplication.classes.LoginForm;
import com.webapplication.entities.User;
import com.webapplication.serviceInterface.UserService;

@Component
public class LoginValidation implements Validator {
	
	
	@Autowired
	private UserService loginServiceImp;

	@Override
	public boolean supports(Class<?> targetClass) {
		
		return LoginForm.class.isAssignableFrom(targetClass);
	}
	

	@Override
	public void validate(Object targetClass, Errors errors) {		
		
		LoginForm logForm = (LoginForm) targetClass;
		User userInfo = loginServiceImp.getUserInfo(logForm.getUserName());
		
		ValidationUtils.rejectIfEmpty(errors, "userName", "Loginvaldat.loginInfo.userName");
		ValidationUtils.rejectIfEmpty(errors, "passWord", "Loginvaldat.loginInfo.passWord");
		
		if(userInfo == null){
			errors.rejectValue("wrongUserOrPass", "Loginvaldat.loginInfo.wrongUserOrPass");
		}else if(!userInfo.getPassWord().equals(logForm.getPassWord())){
			errors.rejectValue("wrongUserOrPass", "Loginvaldat.loginInfo.wrongUserOrPass");
		}
		
		
	}

}
