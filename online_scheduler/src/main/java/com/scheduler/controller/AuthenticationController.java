/**
 * 
 */
package com.scheduler.controller;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scheduler.model.User;
import com.scheduler.model.UserAuthentication;
import com.scheduler.service.AuthenticationService;

/**
 * @author Sanky
 *
 */
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

	private String sessionUUID;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@RequestMapping(value="/authenticate", method = RequestMethod.POST)
	public String autheticateUser(){
		UserAuthentication userAuth = new UserAuthentication();
		userAuth.setUser_name("retrieve from request");
		userAuth.setPassword("retrieve from request");
		if(authenticationService.authenticate(userAuth))
		 this.sessionUUID = UUID.randomUUID().toString();
		return sessionUUID;
	}

	@RequestMapping(value = "/testUser", method = RequestMethod.GET)
	public User testUser() {

		User emp = new User();
		emp.setEmail("blah@blah");
		emp.setFirst_name("blah");
		emp.setLast_name("Blah");
		emp.setPhone(1231235);

		return emp;
	}
	
	
}
