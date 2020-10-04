package com.health.repository;

import org.springframework.data.repository.CrudRepository;

import com.health.model.feedback;
import com.health.model.feedbackMasterTrainer;

	public interface feedbackFOrUser extends CrudRepository<feedback, Integer>
{
	
	
	

}
