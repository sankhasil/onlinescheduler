/**
 * 
 */
package com.scheduler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.scheduler.model.User;
import com.scheduler.model.UserAuthentication;
import com.scheduler.service.UserService;

/**
 * @author Sanky
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	private UserService userService;
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.CREATED)
	public void addUser(){
		//TODO: retrive data from request and create user.
		//FIXME: trying save dummy user.
		logger.debug("add request called");
		User usr = new User();
		usr.setFirst_name("blah");
		usr.setLast_name("blah");
		usr.setEmail("blah@blah.com");
		usr.setPhone(1234567890);
		UserAuthentication userAuthentication = new UserAuthentication();
		userAuthentication.setUser_name("blahuser");
		userAuthentication.setPassword("blahpassword");
		usr.setUserAuthentication(userAuthentication);
		userService.save(usr);
		logger.debug("saving done");
		
	}
	
	public void deleteUser(){
		
	}
	public User getUser(){
		return null;
	}
	
}
