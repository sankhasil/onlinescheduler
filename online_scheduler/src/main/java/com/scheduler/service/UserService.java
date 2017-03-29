/**
 * 
 */
package com.scheduler.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scheduler.model.User;

/**
 * @author Sanky
 *
 */
@Service
public interface UserService {

	
	public List<User> findAll();
	public User findOneByEmail(String email); 
	public void save(User user);
	public void deleteByEmail(String email);
	
}
