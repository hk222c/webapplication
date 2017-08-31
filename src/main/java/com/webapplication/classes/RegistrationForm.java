package com.webapplication.classes;

import com.webapplication.entities.User;

public class RegistrationForm extends User {
	
	private String verificationPassword;

	public String getVerificationPassword() {
		return verificationPassword;
	}

	public void setVerificationPassword(String verificationPassword) {
		this.verificationPassword = verificationPassword;
	}

	@Override
	public String toString() {
		return "RegistrationForm [verificationPassword=" + verificationPassword + ", getVerificationPassword()="
				+ getVerificationPassword() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getPassWord()=" + getPassWord() + ", getEmail()=" + getEmail() + ", getTelePhone()="
				+ getTelePhone() + ", getUserRole()=" + getUserRole() + ", getId()=" + getId() + "]";
	}
	
	

}
