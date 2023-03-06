package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Author;

public interface AuthorService {

//	get list of all authors
	public List<Author> getAuthors();

//	get particular author
	public Author getAuthor(int id);

//	add particular author
	public Author addAuthor(Author author);

//	edit particular author
	public Author editAuthor(Author author, int id);

//	delete particular author
	public void deleteAuthor(int id);

}
