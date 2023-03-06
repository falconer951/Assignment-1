package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Book;

//perform CRUD operation for books
@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
	
}
