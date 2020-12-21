package com.health.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.FeedbackMasterTrainer;

public interface FeedBackRepository extends CrudRepository<FeedbackMasterTrainer, Integer>{
	
	@Query("select max(TrainerFeedId) from FeedbackMasterTrainer")
	int getNewId();

}
