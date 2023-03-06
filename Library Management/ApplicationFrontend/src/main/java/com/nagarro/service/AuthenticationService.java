/**
 * 
 */
package com.nagarro.service;

import com.nagarro.model.User;

public interface AuthenticationService {

	//add user to database
	public void addUser(User user);
	
	//return user
	public User getUserByUsernameAndPassword(String username, String password);
}
