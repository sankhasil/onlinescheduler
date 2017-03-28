package com.scheduler.service;

import java.util.List;

import com.scheduler.model.UserAuthentication;

/**
 * 
 * @author Sanky
 *
 */
public interface AuthenticationService {

public boolean authenticate(UserAuthentication userAuthentication);
public List<UserAuthentication> findAll();
public UserAuthentication findOne(String userId); 
public UserAuthentication findByUserName(String userName);
public void save(UserAuthentication userAuthentication);
public void delete(String userId);
}
