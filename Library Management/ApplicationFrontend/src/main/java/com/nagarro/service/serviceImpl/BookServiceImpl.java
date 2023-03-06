package com.nagarro.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.constant.ApiConstant;
import com.nagarro.model.Book;
import com.nagarro.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private RestTemplate restTemplate;

	
	public Book getBook(long bookCode) {
		Book book = restTemplate.getForObject(ApiConstant.BOOK_URL + bookCode, Book.class);
		return book;
	}

	
	public List<Book> getBooks() {
		@SuppressWarnings("unchecked")
		List<Book> listOfBooks = (List<Book>) restTemplate.getForObject(ApiConstant.BOOK_URL, List.class);
		return listOfBooks;
	}

	
	public void addBook(Book book) {
		restTemplate.postForEntity(ApiConstant.BOOK_URL, book, Book.class);

	}

	public void editBook(Book book) {
		restTemplate.put(ApiConstant.BOOK_URL + book.getCode(), book, Book.class);
	}

	
	public void deleteBook(long bookCode) {
		restTemplate.delete(ApiConstant.BOOK_URL + bookCode, Book.class);
	}

}
