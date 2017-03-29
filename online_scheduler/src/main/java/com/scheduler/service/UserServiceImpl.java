/**
 * 
 */
package com.scheduler.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scheduler.model.User;
import com.scheduler.repository.UserRepository;

/**
 * @author Sanky
 *
 */
@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOneByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) {
		//Check if user already exists based on email
		//userRepository.exists("wirte queryby example");
		userRepository.save(user);
		
	}

	@Override
	public void deleteByEmail(String email) {
		// TODO Auto-generated method stub
		
	}

}
