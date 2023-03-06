package com.nagarro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int userId;
	String fullname;

	@Column(name = "Username")
	String username;
	String password;
	String email;
	
	public User() {
		super();
	}

	public User(String fullname, String username, String password, String email) {
		super();
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
