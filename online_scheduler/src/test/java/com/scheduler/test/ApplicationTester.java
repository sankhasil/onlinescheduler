/**
 * 
 */
package com.scheduler.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.scheduler.ApplicationRunner;
import com.scheduler.persistance.repository.JobRepository;
import com.scheduler.persistance.repository.UserRepository;

/**
 * @author Sanky
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationRunner.class)
public class ApplicationTester {
	
	@Autowired
	protected JobRepository jobRepo;
	@Autowired
	protected UserRepository userRepo;

	@Test
	public void contextLoads() {

	}
}
