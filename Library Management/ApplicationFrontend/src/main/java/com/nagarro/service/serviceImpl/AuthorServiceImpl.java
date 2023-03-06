package com.nagarro.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.constant.ApiConstant;
import com.nagarro.model.Author;
import com.nagarro.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private RestTemplate restTemplate;

	public List<Author> getAuthors() {
		@SuppressWarnings("unchecked")
		List<Author> listOfAuthors = (List<Author>) restTemplate.getForObject(ApiConstant.AUTHOR_URL, List.class);
		return listOfAuthors;
	}

}
