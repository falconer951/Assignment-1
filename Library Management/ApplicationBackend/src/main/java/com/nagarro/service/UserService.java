package com.nagarro.service;

import java.util.List;

import com.nagarro.model.User;

public interface UserService {
//	return list of all users
	public List<User> getUsers();

//	add user to current session
	public User addUser(User user);

//	return current user
	public User getUser(String username, String password);
}
