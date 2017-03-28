package com.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scheduler.model.UserAuthentication;

public interface UserAuthenticationRepository extends JpaRepository<UserAuthentication, Long> {
	

}
