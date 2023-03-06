package com.nagarro.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.constant.ApiConstant;
import com.nagarro.model.User;
import com.nagarro.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private RestTemplate restTemplate;

	public void addUser(User user) {
		ResponseEntity<String> response = restTemplate.postForEntity(ApiConstant.USER_URL, user, String.class);
		HttpStatus statusCode = response.getStatusCode();
		HttpHeaders responseHeader = response.getHeaders();
		String responseBody = response.getBody();
		System.out.println(statusCode + responseBody + responseHeader);

	}

	public User getUserByUsernameAndPassword(String username, String password) {
		ResponseEntity<String> response = restTemplate.getForEntity(ApiConstant.USER_URL + username + "/" + password,
				String.class);
		HttpStatus statusCode = response.getStatusCode();
		HttpHeaders responseHeader = response.getHeaders();
		String responseBody = response.getBody();
		System.out.println(statusCode + responseBody + responseHeader);
		User user = restTemplate.getForObject(ApiConstant.USER_URL + username + "/" + password, User.class);
		return user;
	}

}
