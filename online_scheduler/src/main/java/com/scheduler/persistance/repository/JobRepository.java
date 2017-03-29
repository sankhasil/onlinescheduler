/**
 * 
 */
package com.scheduler.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scheduler.model.Job;

/**
 * @author Sanky
 *
 */
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

	@Query("select j from Job j where j.user_id = ?1")
	public List<Job> findAllByUser(long user_id);
	
	@Query("SELECT j from Job j where j.job_name =?1")
	public Job findByJobName(String job_name);
	
	
}
