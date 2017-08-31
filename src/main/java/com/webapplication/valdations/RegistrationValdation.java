package com.webapplication.valdations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.webapplication.classes.RegistrationForm;

@Component
public class RegistrationValdation implements Validator {
	

	@Override
	public boolean supports(Class<?> targetClass) {
		
		return RegistrationForm.class.isAssignableFrom(targetClass);
	}
	

	@Override
	public void validate(Object targetClass, Errors errors) {
		
		RegistrationForm registreForm = (RegistrationForm) targetClass;
		
		ValidationUtils.rejectIfEmpty(errors, "firstName", "Registrationvaldat.registreInfo.firstName");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "Registrationvaldat.registreInfo.lastName");
		ValidationUtils.rejectIfEmpty(errors, "passWord", "Registrationvaldat.registreInfo.passWord");
		ValidationUtils.rejectIfEmpty(errors, "verificationPassword", "Registrationvaldat.registreInfo.verificationPassword");
		ValidationUtils.rejectIfEmpty(errors, "email", "Registrationvaldat.registreInfo.email");
		ValidationUtils.rejectIfEmpty(errors, "telePhone", "Registrationvaldat.registreInfo.telePhone");
		
		if(!registreForm.getPassWord().equals(registreForm.getVerificationPassword())){
			errors.rejectValue("passWord", "Registrationvaldat.registreInfo.passDontmatch");
			errors.rejectValue("verificationPassword", "Registrationvaldat.registreInfo.passDontmatch");
		}
		
		
		
	}

}
