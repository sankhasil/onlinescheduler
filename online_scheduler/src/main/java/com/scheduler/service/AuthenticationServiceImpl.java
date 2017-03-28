/**
 * 
 */
package com.scheduler.service;

import java.util.List;

import com.scheduler.model.UserAuthentication;

/**
 * @author Sanky
 *
 */
public class AuthenticationServiceImpl implements AuthenticationService {

	@Override
	public boolean authenticate(UserAuthentication userAuthentication) {
		UserAuthentication dataFromDb = this.findByUserName(userAuthentication.getUser_name());
		if(dataFromDb.equals(userAuthentication))
			return true;
		return false;
	}

	@Override
	public List<UserAuthentication> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAuthentication findOne(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(UserAuthentication userAuthentication) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserAuthentication findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
