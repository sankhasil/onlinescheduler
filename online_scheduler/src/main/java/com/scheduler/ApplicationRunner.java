package com.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.scheduler.properties.ApplicationEnvironment;

/**
 * 
 * @author Sanky
 *
 */
@SpringBootApplication
//@ComponentScan("com.scheduler")
public class ApplicationRunner {

	public ApplicationRunner() {
	}

	public static void main(String... args) {
		  ApplicationContext ctx = SpringApplication.run(ApplicationRunner.class, args);
		ApplicationEnvironment.setApplicationEnvironment(ctx.getEnvironment());
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//         
//        Arrays.sort(beanNames);
//         
//        for (String beanName : beanNames) 
//        {
//            System.out.println(beanName);
//        }
	}

}
