/**
 * 
 */
package com.scheduler.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scheduler.model.User;

/**
 * @author Sanky
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u from User u where u.email =?1")
	public User findByEmail(String email);
	@Query("select u from User u where u.user_name = ?1")
	public User findByUser_name(String user_name);
}
