package com.health.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.TrainingTopic;

public interface TrainingTopicRepository extends CrudRepository<TrainingTopic, Integer>{

	@Query("select max(trainingTopicId) from TrainingTopic")
	int getNewId();
}
