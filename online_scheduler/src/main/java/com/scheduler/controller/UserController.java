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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody User user) {
		logger.info("Add request called");
		User userFromDb = userService.findOneByEmail(user.getEmail());
		if (userFromDb != null && userFromDb.equals(user)) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		userService.save(user);
		String userTokenId = user.getEmail() + "::" + user.getUser_name();
		logger.info("user saving done");
		return new ResponseEntity<>(userTokenId, HttpStatus.CREATED);
	}

}
