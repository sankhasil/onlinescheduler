/**
 * 
 */
package com.scheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.scheduler.model.User;
import com.scheduler.service.UserService;

/**
 * @author Sanky
 *
 */
@RestController
// @CrossOrigin(origins = "http://localhost:9080") Required for UI
@RequestMapping("/authentication")
public class AuthenticationController {

	@Autowired
	private UserService authenticationService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> autheticateUser(@RequestBody User userAuth) {
		if (userAuth != null) {
			User usr = authenticationService.findOneByUserName(userAuth.getUser_name());
			if (usr != null && usr.getPassword().equals(userAuth.getPassword())) {
				return new ResponseEntity<User>(usr, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
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
		emp.setUser_name("blahblah");
		emp.setPassword("blahPassword"); // FIXME: password
											// encryption-decryption
		return emp;
	}

}
