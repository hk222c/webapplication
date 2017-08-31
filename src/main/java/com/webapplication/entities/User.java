package com.webapplication.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.webapplication.enmus.Roles;

@Entity
@Table(name="userInfo")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private String passWords;
	
	@NotNull @Email
	private String email;
	
	private int telePhone;
	
	@NotNull
	private Roles userRole;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassWord() {
		return passWords;
	}

	public void setPassWord(String passWord) {
		this.passWords = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelePhone() {
		return telePhone;
	}

	public void setTelePhone(int telePhone) {
		this.telePhone = telePhone;
	}

	public Roles getUserRole() {
		return userRole;
	}

	public void setUserRole(Roles userRole) {
		this.userRole = userRole;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", passWord=" + passWords
				+ ", email=" + email + ", telePhone=" + telePhone + ", userRole=" + userRole + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + ", getPassWord()=" + getPassWord()
				+ ", getEmail()=" + getEmail() + ", getTelePhone()=" + getTelePhone() + ", getUserRole()="
				+ getUserRole() + ", getId()=" + getId() + "]";
	}
	
	
	
	

}
