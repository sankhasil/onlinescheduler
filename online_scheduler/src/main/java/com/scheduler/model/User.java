/**
 * 
 */
package com.scheduler.model;

import javax.persistence.CascadeType;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Sanky
 *
 */
@Entity
@Table(name = "user_details")
public class User {
	
	
	private UserAuthentication userAuthentication;
	private String first_name;
	private String last_name;
	private String email;
	private Integer phone;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
	public UserAuthentication getUserAuthentication() {
		return userAuthentication;
	}
	public void setUserAuthentication(UserAuthentication userAuthentication) {
		this.userAuthentication = userAuthentication;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return String.format(
                "User[user=%d, name='%s', email='%s', phone='%d']",
                userAuthentication.getUser_name(), first_name+" "+last_name, email,phone);
	}
	

}
