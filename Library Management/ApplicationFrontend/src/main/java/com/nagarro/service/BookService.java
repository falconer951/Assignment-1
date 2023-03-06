package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Book;

public interface BookService {
	
	//return particular book
	public Book getBook(long bookCode);
	
	//return list of books
	public List<Book> getBooks();
	
	//add a particular book
	public void addBook(Book book);
	
	//edit a particular book
	public void editBook(Book book);

	//delete a particular book
	public void deleteBook(long bookCode);

}
