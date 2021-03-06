/**
 * 
 */
package com.scheduler.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.scheduler.model.User;

/**
 * @author Sanky
 *
 */
public class AuthenticationTest extends ApplicationTester {
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void dummyTest() throws Exception {
		mockMvc.perform(get("/authentication/testUser")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.first_name").value("blah")).andExpect(jsonPath("$.last_name").value("Blah"))
				.andExpect(jsonPath("$.email").value("blah@blah")).andExpect(jsonPath("$.phone").value(1231235));

	}
	

	@Test
	public void testAuthenticateValidUser() throws Exception {
		
		User user = new User();
		user.setEmail("somelast@last.com");
		user.setFirst_name("some");
		user.setUser_name("somelast");
		user.setPassword("somelast");
		userRepo.save(user);
		mockMvc.perform(post("/authentication/authenticate").contentType(MediaType.APPLICATION_JSON).content("{\"user_name\":\"somelast\",\"password\":\"somelast\"}")).andExpect(status().isOk());

	}
	
	@Test
	public void testAuthenticateInValidUser() throws Exception {
		mockMvc.perform(post("/authentication/authenticate").contentType(MediaType.APPLICATION_JSON).content("{\"user_name\":\"wrong\",\"password\":\"wrong\"}")).andExpect(status().isUnauthorized());

	}
	
	@Test
	public void testAuthenticateNoUser() throws Exception {
		mockMvc.perform(post("/authentication/authenticate").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());

	}


}
