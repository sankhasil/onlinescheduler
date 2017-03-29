/**
 * 
 */
package com.scheduler.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.scheduler.execution.ApplicationRunner;

/**
 * @author Sanky
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=ApplicationRunner.class)
public class ApplicationTester {

	@Test
	public void contextLoads(){
		
	}
}
