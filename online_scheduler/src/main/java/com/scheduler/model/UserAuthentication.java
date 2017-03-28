/**
 * 
 */
package com.scheduler.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Sanky
 *
 */
@Entity
@Table(name="user_authentication")
public class UserAuthentication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String user_id;

	private String user_name;
	private String password;

	private User user;
	public String getUser_id() {
		return user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToOne(mappedBy = "userAuthentication" )
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
