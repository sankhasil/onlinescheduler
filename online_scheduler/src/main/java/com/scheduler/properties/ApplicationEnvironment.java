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
}
