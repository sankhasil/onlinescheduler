/**
 * 
 */
package com.scheduler.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.scheduler.model.User;

/**
 * @author Sanky
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u from User u where u.email =?1")
	public User findByEmail(String email);
}
