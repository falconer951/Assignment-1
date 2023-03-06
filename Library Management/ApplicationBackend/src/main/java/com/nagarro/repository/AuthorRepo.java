package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Author;

// performing CRUD operations for author
@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {

}
