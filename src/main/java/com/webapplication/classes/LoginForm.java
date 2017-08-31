package com.webapplication.classes;

public class LoginForm {
	
	private String userName;
	
	private String passWord;
	
	private String wrongUserOrPass;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	

	public String getWrongUserOrPass() {
		return wrongUserOrPass;
	}

	public void setWrongUserOrPass(String wrongUserOrPass) {
		this.wrongUserOrPass = wrongUserOrPass;
	}

	@Override
	public String toString() {
		return "LoginForm [userName=" + userName + ", passWord=" + passWord + ", wrongUserOrPass=" + wrongUserOrPass
				+ "]";
	}
	
	
	
	

}
