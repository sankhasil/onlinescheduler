/**
 * 
 */
package com.scheduler.service;

import java.util.List;

import com.scheduler.model.Job;

/**
 * @author Sanky
 *
 */
public interface JobService {

	public List<Job> getAllByUser(long userId);
	public void add(Job job);
	public void delete(long jobId);
	public boolean checkExistance(Job job);
	public void updateJobStatus(long jobId,String status);
	
}
