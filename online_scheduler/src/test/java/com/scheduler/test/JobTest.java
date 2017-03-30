/**
 * 
 */
package com.scheduler.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
	
	/*
	 * Job creation is not happening due to hibernate automatic @id generation.
	 */
	@Test
	public void testAddJob() throws Exception {
		mockMvc.perform(post("/job/add").contentType(MediaType.APPLICATION_JSON).content("{\"job_name\": \"blah\",\"job_command\": \"1 0 * * *  printf > /var/log/apache/error_log\",\"job_description\":\"blahh\" ,\"user_id\":2 }")).andExpect(status().isCreated());

	}
	
	/*
	 * Since I have inserted a job with user_id 2 and as per initialzation script somelast user is created with id 2
	 * 
	 */
	@Test
	public void testGetAllJob() throws Exception{
		
		mockMvc.perform(get("/getAll/{Number}",2)).andExpect(status().isOk());
	}
	/*
	 * Assuming only one job is geting created with id 1 as autogenration
	 */
	@Test
	public void testActivateJob() throws Exception{
		mockMvc.perform(post("/activate/{Number}",1)).andExpect(status().isOk());
	}
	@Test
	public void testDeActivateJob() throws Exception{
		mockMvc.perform(post("/deActivate/{Number}",1)).andExpect(status().isOk());
	}
}
