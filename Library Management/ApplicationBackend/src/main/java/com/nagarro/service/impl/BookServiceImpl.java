package com.nagarro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.exception.ResourceNotFoundException;
import com.nagarro.model.Book;
import com.nagarro.repository.BookRepo;
import com.nagarro.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepo bookRepository;
	public List<Book> list;

	
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	public Book getBook(long bookCode) {
		return bookRepository.findById(bookCode)
				.orElseThrow(() -> new ResourceNotFoundException("Book", "bookCode", bookCode));
	}
	
	public Book addBook(Book book) {
		bookRepository.save(book);
		return book;
	}

	public Book editBook(Book book, long bookCode) {
		Book existingBook = bookRepository.findById(bookCode)
				.orElseThrow(() -> new ResourceNotFoundException("Book", "bookCode", bookCode));
		existingBook.setAuthor(book.getAuthor());
		existingBook.setName(book.getName());

		bookRepository.save(existingBook);
		return existingBook;
	}

	public void deleteBook(long bookCode) {
		bookRepository.findById(bookCode)
		.orElseThrow(() -> new ResourceNotFoundException("Book", "bookCode", bookCode));
		bookRepository.deleteById(bookCode);

	}

}
