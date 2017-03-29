/**
 * 
 */
package com.scheduler.properties;

import org.springframework.core.env.Environment;

/**
 * @author Sanky
 *
 */
public final class ApplicationEnvironment {

	private static  Environment applicationEnvironment;
	private ApplicationEnvironment() {
	}

	public static void setApplicationEnvironment( Environment applicationProperties){
		ApplicationEnvironment.applicationEnvironment = applicationProperties;
	}
	public static String getAuthenticationToken(){
		return applicationEnvironment.getProperty("authentication.token.online");
	}
	public static String getJdbcUrl(){
		return applicationEnvironment.getProperty("spring.datasource.url");
	}
	public static String getJdbcDriverName(){
		return applicationEnvironment.getProperty("jdbc.driver.class");
	}
	
	public static String getJdbcUser(){
		return applicationEnvironment.getProperty("spring.datasource.username");
	}
	public static String getJdbcPassword(){
		return applicationEnvironment.getProperty("spring.datasource.password");
	}
}
