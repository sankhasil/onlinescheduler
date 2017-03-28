package com.scheduler.execution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Sanky
 *
 */
@SpringBootApplication
public class ApplicationRunner {

	public ApplicationRunner() {
	}
	public static void main(String...args){
		SpringApplication.run(ApplicationRunner.class, args);
	}

}
