package com.nagarro.model;

public class User {
	String fullname;
	String username;
	String password;
	String email;

	public User() {

	}

	public User(String fullname, String username, String password, String email) {
		super();
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.email = email;
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
