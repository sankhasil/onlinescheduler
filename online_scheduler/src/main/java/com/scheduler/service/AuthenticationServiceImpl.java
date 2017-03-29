/**
 * 
 */
package com.scheduler.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.scheduler.model.UserAuthentication;
import com.scheduler.persistance.repository.UserAuthenticationRepository;

/**
 * @author Sanky
 *
 */
@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

	private UserAuthenticationRepository userAuthenticationRepository;

	@Override
	public boolean authenticate(UserAuthentication userAuthentication) {
		UserAuthentication dataFromDb = this.findByUserName(userAuthentication.getUser_name());
		if (dataFromDb.equals(userAuthentication))
			return true;
		return false;
	}

	@Override
	public List<UserAuthentication> findAll() {
		return userAuthenticationRepository.findAll();
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
		// TODO: query for fetching user authentication details :
		return userAuthenticationRepository.findByUserName(userName);
	}

}
