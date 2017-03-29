/**
 * 
 */
package com.scheduler.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sanky
 *
 */
@Entity
@Table(name="job_details")
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long user_id;
	
	private String job_name;
	private String job_description;
	private String job_command;
	
	private String job_status;
	
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getJob_description() {
		return job_description;
	}
	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}
	public String getJob_command() {
		return job_command;
	}
	public void setJob_command(String job_command) {
		this.job_command = job_command;
	}
	
	public String getJob_status() {
		return job_status;
	}
	public void setJob_status(String job_status) {
		this.job_status = job_status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((job_name == null) ? 0 : job_name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Job)) {
			return false;
		}
		Job other = (Job) obj;
		if (job_name == null) {
			if (other.job_name != null) {
				return false;
			}
		} else if (!job_name.equalsIgnoreCase(other.job_name)) {
			return false;
		}
		return true;
	}
	
	

}
