package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Author;
import com.nagarro.service.AuthorService;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
//	this method is to get all the authors REST API
	@GetMapping
	public List<Author> getBookList() {

		return authorService.getAuthors();
	}

//	this method is to get an author by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Author> getBook(@PathVariable("id") int id) {

		return new ResponseEntity<Author>(authorService.getAuthor(id), HttpStatus.OK);
	}
	
//	this method is to add an author REST API
	@PostMapping
	public ResponseEntity<Author> addBook(@RequestBody Author author) {

		return new ResponseEntity<Author>(authorService.addAuthor(author), HttpStatus.CREATED);
	}
	
//	this method is to edit an author REST API
	@PutMapping("{id}")
	public ResponseEntity<Author> editBook(@PathVariable("id") int id, @RequestBody Author author) {

		return new ResponseEntity<Author>(authorService.editAuthor(author, id), HttpStatus.OK);
	}
		
//	this method is to delete an author REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") int id) {

		authorService.deleteAuthor(id);
		return new ResponseEntity<String>("Author Deleted", HttpStatus.OK);

	}
	
}
