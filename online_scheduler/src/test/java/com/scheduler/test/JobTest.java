/**
 * 
 */
package com.scheduler.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
public class JobTest extends ApplicationTester {
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	@Test
	public void testAddJob() throws Exception {
		mockMvc.perform(post("/job/add").contentType(MediaType.APPLICATION_JSON).content("{\"job_name\": \"blah\",\"job_command\": \"1 0 * * *  printf > /var/log/apache/error_log\",\"job_description\":blahh }")).andExpect(status().isCreated());

	}
}
