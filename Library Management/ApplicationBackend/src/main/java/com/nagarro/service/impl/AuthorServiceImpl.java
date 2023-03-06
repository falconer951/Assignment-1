package com.nagarro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.exception.ResourceNotFoundException;
import com.nagarro.model.Author;
import com.nagarro.repository.AuthorRepo;
import com.nagarro.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepo authorRepository;
	public List<Author> list;

	@Override
	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public Author getAuthor(int id) {
		return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
	}

	@Override
	public Author addAuthor(Author author) {
		authorRepository.save(author);
		return author;
	}

	@Override
	public Author editAuthor(Author author, int id) {
		Author existingAuthor = authorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Author", "Id", id));
		existingAuthor.setAuthorName(author.getAuthorName());

		authorRepository.save(existingAuthor);
		return existingAuthor;
	}

	@Override
	public void deleteAuthor(int id) {
		authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "Id", id));
		authorRepository.deleteById(id);

	}

}
