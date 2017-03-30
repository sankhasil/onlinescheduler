/**
 * 
 */
package com.scheduler.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.scheduler.model.Job;
import com.scheduler.persistance.repository.JobRepository;

/**
 * @author Sanky
 *
 */
@Service
@Transactional
public class JobServiceImpl implements JobService {

	private JobRepository jobRepository;

	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override
	public List<Job> getAllByUser(long userID) {
		return jobRepository.findAllByUser_id(userID);
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
		Job jobFromDb = jobRepository.findByJobName(job.getJob_name());
		return jobFromDb != null ? jobFromDb.equals(job) : false;
	}

	@Override
	public void updateJobStatus(long jobId, String status) {

		Job job = jobRepository.findOne(jobId);
		job.setJob_status(status);
		jobRepository.save(job);

	}
}
