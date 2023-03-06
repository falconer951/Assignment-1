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

import com.nagarro.model.Book;
import com.nagarro.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
	@Autowired
	private BookService bookService;

//	this method is to get all the book REST API
	@GetMapping
	public List<Book> getBookList() {

		return this.bookService.getBooks();
	}

//	this method is to get particular book REST API
	@GetMapping("{bookCode}")
	public ResponseEntity<Book> getBooks(@PathVariable("bookCode") long bookCode) {

		return new ResponseEntity<Book>(bookService.getBook(bookCode), HttpStatus.OK);
	}

//	this method is to build add books REST API
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {

		return new ResponseEntity<Book>(bookService.addBook(book), HttpStatus.CREATED);
	}

//	this method is to build edit books REST API
	@PutMapping("{bookCode}")
	public ResponseEntity<Book> editBook(@PathVariable("bookCode") long bookCode, @RequestBody Book book) {

		return new ResponseEntity<Book>(bookService.editBook(book, bookCode), HttpStatus.OK);
	}

//	this method is to delete edit books REST API
	@DeleteMapping("{bookCode}")
	public ResponseEntity<String> deleteBook(@PathVariable("bookCode") long bookCode) {

		bookService.deleteBook(bookCode);
		return new ResponseEntity<String>("Book Deleted", HttpStatus.OK);

	}
}
