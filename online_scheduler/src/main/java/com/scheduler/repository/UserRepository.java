/**
 * 
 */
package com.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.scheduler.model.User;

/**
 * @author Sanky
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
