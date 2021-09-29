package com.camel.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.camel.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
 
	@Query("SELECT u FROM User u WHERE u.username = ?1")
	 User findUserByUsername(String username);
	@Query("SELECT u FROM User u WHERE u.username =?1 and u.password =?2")
	User findUserByUsernameAndPassword(String username,String password);
}
