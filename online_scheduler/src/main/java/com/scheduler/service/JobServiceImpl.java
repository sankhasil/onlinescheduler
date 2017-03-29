/**
 * 
 */
package com.scheduler.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scheduler.model.Job;
import com.scheduler.persistance.repository.JobRepository;

/**
 * @author Sanky
 *
 */
@Service
public class JobServiceImpl implements JobService {

	JobRepository jobRepository;

	@Override
	public List<Job> getAllByUser(long userID) {
		return jobRepository.findAllByUser(userID);
	}

	@Override
	public void add(Job job) {
		jobRepository.save(job);

	}

	@Override
	public void delete(long jobId) {
		jobRepository.delete(jobId);
	}

	@Override
	public boolean checkExistance(Job job) {
		
		return jobRepository.findByJobName(job.getJob_name()).equals(job);
	}
	@Override
	public void updateJobStatus(long jobId,String status) {
	
		Job job = jobRepository.findOne(jobId);
		job.setJob_status(status);
		jobRepository.saveAndFlush(job);
		
		
	}
}
