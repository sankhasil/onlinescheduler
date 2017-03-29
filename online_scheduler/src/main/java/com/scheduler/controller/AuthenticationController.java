/**
 * 
 */
package com.scheduler.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.scheduler.model.User;
import com.scheduler.model.UserAuthentication;
import com.scheduler.properties.ApplicationEnvironment;

/**
 * @author Sanky
 *
 */
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

	// @Autowired
	// private AuthenticationService authenticationService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> autheticateUser(@RequestBody UserAuthentication userAuth) {
			// FIXME: get the id by query in db. Which actually follows by
			// authentication
			// getUser from db
		System.out.println("Authentication controller called");
			if (userAuth != null) {
				User usr = new User();
				usr.setUserAuthentication(userAuth);
				//if user not found then return unAuthorized
				return new ResponseEntity<User>(usr, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/testUser", method = RequestMethod.GET)
	public User testUser() {

		User emp = new User();
		emp.setEmail("blah@blah");
		emp.setFirst_name("blah");
		emp.setLast_name("Blah");
		emp.setPhone(1231235);
		UserAuthentication usrA = new UserAuthentication();
		usrA.setUser_name("blahblah");
		usrA.setPassword("blahPassword"); // FIXME: password
											// encryption-decryption
		emp.setUserAuthentication(usrA);

		return emp;
	}

}
