package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.model.User;

// perform CRUD operation for User
@Repository
public interface UserRepo extends JpaRepository<User, String> {
	
	@Query("from User where username = ?1 AND password = ?2")
	User findByUsernameByPassword(String username, String password);
}
