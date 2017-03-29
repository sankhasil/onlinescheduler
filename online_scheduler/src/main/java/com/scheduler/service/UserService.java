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
public interface UserService {

	
	public List<User> findAll();
	public User findOneByEmail(String email); 
	public User findOneByUserName(String user_name);
	public void save(User user);
	public void deleteByEmail(String email);
	
}
