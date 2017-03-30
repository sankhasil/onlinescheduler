/**
 * 
 */
package com.scheduler.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.swing.text.AbstractDocument.Content;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.scheduler.model.Job;

/**
 * @author Sanky
 *
 */
public class JobTest extends ApplicationTester {
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	private Job job;

	@Before
	public void setup() {
		job = new Job();
		job.setUser_id(1);
		job.setJob_status("active");
		job.setJob_name("test Job");
		job.setJob_description("test description");
		job.setJob_command("2 4 * * * 5 / runcommand");

		jobRepo.save(job);

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void cleanup() {
		jobRepo.deleteAll();
		// do cleanup db
	}

	@Test
	public void testAddJob() throws Exception {
		mockMvc.perform(post("/job/add").contentType(MediaType.APPLICATION_JSON).content(
				"{\"job_name\": \"blah\",\"job_command\": \"1 0 * * *  printf > /var/log/apache/error_log\",\"job_description\":\"blahh\" ,\"user_id\":1 }"))
				.andExpect(status().isCreated());

	}

	@Test
	public void testGetAllJob() throws Exception {
		mockMvc.perform(get("/job/getAll/{Number}", job.getUser_id())).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[*].job_name").exists());
	}

	@Test
	public void testActivateJob() throws Exception {
		mockMvc.perform(post("/job/activate/{Number}", job.getId())).andExpect(status().isOk());
	}

	@Test
	public void testDeActivateJob() throws Exception {
		mockMvc.perform(post("/job/deActivate/{Number}", job.getId())).andExpect(status().isOk());
	}
}
