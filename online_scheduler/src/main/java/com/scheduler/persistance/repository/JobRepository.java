/**
 * 
 */
package com.scheduler.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.scheduler.model.Job;

/**
 * @author Sanky
 *
 */
public interface JobRepository extends JpaRepository<Job, Long> {

	@Query("select j from Job j where j.user_id = ?1")
	public List<Job> findAllByUser(long userId);
	
	@Query("SELECT j from Job j where j.job_name =?1")
	public Job findByJobName(String jobName);
	
	
}
