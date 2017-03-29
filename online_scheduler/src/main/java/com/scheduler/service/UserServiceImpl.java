/**
 * 
 */
package com.scheduler.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.scheduler.model.User;
import com.scheduler.persistance.repository.UserRepository;

/**
 * @author Sanky
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	public  UserServiceImpl(UserRepository userRepo) {
		this.userRepository = userRepo;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findOneByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);

	}

	@Override
	public User findOneByUserName(String user_name) {
		return userRepository.findByUser_name(user_name);
	}
	@Override
	public void deleteByEmail(String email) {

		User user = userRepository.findByEmail(email);
		userRepository.delete(user);
	}

}
