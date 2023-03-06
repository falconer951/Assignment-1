package com.nagarro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.model.User;
import com.nagarro.repository.UserRepo;
import com.nagarro.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepository;

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User addUser(User user) {
		userRepository.save(user);
		return user;
	}

	public User getUser(String username, String password) {
		User result = userRepository.findByUsernameByPassword(username, password);
		if (result == null) {
			result = null;
		}
		return result;
	}
}
