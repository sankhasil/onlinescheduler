/**
 * 
 */
package com.scheduler.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Sanky
 *
 */
public class UserTest extends ApplicationTester {
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testAddUser() throws Exception {
		mockMvc.perform(post("/user/add").contentType(MediaType.APPLICATION_JSON).content("{\"userAuthentication\": {\"user_name\": \"blah\",\"password\": \"blahblah\"},\"first_name\": \"fist blah\",\"last_name\": \"last blah\",\"email\": \"blah@blah\",\"phone\": 3322445}")).andExpect(status().isCreated());

	}
	
	
}
