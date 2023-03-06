package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Book;

public interface BookService {

//	get list of all books
	public List<Book> getBooks();
	
//	get particular book
	public Book getBook(long bookCode);
	
//	add particular book
	public Book addBook(Book book);
	
//	edit particular book
	public Book editBook(Book book, long bookCode);
	
//	delete particular book
	public void deleteBook(long bookCode);

}
