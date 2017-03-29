package com.scheduler.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.scheduler.model.UserAuthentication;

public interface UserAuthenticationRepository extends JpaRepository<UserAuthentication, Long> {
	
	@Query("select u from User u where u.user_name = ?1")
	UserAuthentication findByUserName(String username);

}
