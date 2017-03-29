/**
 * 
 */
package com.scheduler.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scheduler.model.User;
import com.scheduler.service.UserService;

/**
 * @author Sanky
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	
	public void addUser(){
		
		
	}
	
	public void deleteUser(){
		
	}
	public User getUser(){
		return null;
	}
	
}
