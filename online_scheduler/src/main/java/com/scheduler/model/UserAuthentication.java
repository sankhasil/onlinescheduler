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
	private long id;
	private String user_name;
	private String password;

	private User user;
	
	
	public long getId() {
		return id;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof UserAuthentication)) {
			return false;
		}
		UserAuthentication other = (UserAuthentication) obj;
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (user_name == null) {
			if (other.user_name != null) {
				return false;
			}
		} else if (!user_name.equals(other.user_name)) {
			return false;
		}
		return true;
	}
}
