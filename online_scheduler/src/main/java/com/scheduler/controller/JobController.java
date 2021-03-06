package com.scheduler.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.scheduler.model.Job;
import com.scheduler.service.JobService;

@RestController
//@CrossOrigin(origins = "http://localhost:9080") Required for UI
@RequestMapping("/job")
public class JobController {

	private static final Logger logger = LoggerFactory.getLogger(JobController.class);
	@Autowired
	private JobService jobService;

	//Since after authentication user is returned to UI, Job request will have the user_id field with proper user's id
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> addJob(@RequestBody Job job) {
		if (job != null) {
			if (jobService.checkExistance(job)) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			jobService.add(job);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/getAll/{userId}", method = RequestMethod.GET)
	public List<Job> getAll(@PathVariable Long userId) {
		return jobService.getAllByUser(userId);
	}

	@RequestMapping(value = "/delete/{jobId}", method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteJob(@PathVariable Long jobId) {
		jobService.delete(jobId);
	}

	@RequestMapping(value = "/activate/{jobId}", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.OK)
	public void activateJob(@PathVariable Long jobId) {
		jobService.updateJobStatus(jobId, "active");
	}

	@RequestMapping(value = "/deActivate/{jobId}", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.OK)
	public void deActivateJob(@PathVariable Long jobId) {
		jobService.updateJobStatus(jobId, "deactive");
	}
}
