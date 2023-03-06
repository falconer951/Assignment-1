package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.User;
import com.nagarro.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;

//	this method is to add a user
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) {

		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
	}

//	returns list of all users
	@GetMapping
	public List<User> getAllUsers() {

		return userService.getUsers();
	}

//	this method is to get user by userName and password REST API
	@GetMapping("{username}/{password}")
	public ResponseEntity<User> getUser(@PathVariable("username") String username,
			@PathVariable("password") String password) {

		return new ResponseEntity<User>(userService.getUser(username, password), HttpStatus.OK);
	}
}
