package com.scheduler.execution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author Sanky
 *
 */
@SpringBootApplication
@ComponentScan("com.scheduler")
public class ApplicationRunner {

	public ApplicationRunner() {
	}
	public static void main(String...args){
		SpringApplication.run(ApplicationRunner.class, args);
	}

}
