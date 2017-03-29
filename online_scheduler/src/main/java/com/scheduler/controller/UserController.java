/**
 * 
 */
package com.scheduler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.scheduler.model.User;
import com.scheduler.model.UserAuthentication;
import com.scheduler.properties.ApplicationEnvironment;
import com.scheduler.service.UserService;

/**
 * @author Sanky
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	// @Autowired
	private UserService userService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody User user,
			@RequestHeader("Authorization") String authentication) {
		if (authentication.equals(ApplicationEnvironment.getAuthenticationToken())) {
			logger.info("add request called");
			if(userService.findOneByEmail(user.getEmail()).getUserAuthentication().equals(user.getUserAuthentication())){
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			//FIXME: do saving in db and generate the id.
			String userTokenId = user.getEmail() + "::" + user.getUserAuthentication().getUser_name();
			logger.info("saving done");
			return new ResponseEntity<>(userTokenId, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	public void deleteUser() {
		//TODO:: to be implemented
	}

	public User getUser() {
		//TODO :: future implementation
		return null;
	}

}
