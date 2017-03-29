/**
 * 
 */
package com.scheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.model.UserAuthentication;
import com.scheduler.repository.UserAuthenticationRepository;

/**
 * @author Sanky
 *
 */
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	UserAuthenticationRepository userAuthenticationRepository;
	@Override
	public boolean authenticate(UserAuthentication userAuthentication) {
		UserAuthentication dataFromDb = this.findByUserName(userAuthentication.getUser_name());
		if(dataFromDb.equals(userAuthentication))
			return true;
		return false;
	}

	@Override
	public List<UserAuthentication> findAll() {
		return userAuthenticationRepository.findAll();
	}

	@Override
	public UserAuthentication findOne(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(UserAuthentication userAuthentication) {
		userAuthenticationRepository.save(userAuthentication);
		
	}

	@Override
	public void delete(Long userId) {
		userAuthenticationRepository.delete(userId);
		
	}

	@Override
	public UserAuthentication findByUserName(String userName) {
		//TODO: query for fetching user authentication details : userAuthenticationRepository.findOne(username based query)
		return null;
	}

}
