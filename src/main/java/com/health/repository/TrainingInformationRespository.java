package com.health.repository;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.health.model.TopicCategoryMapping;
import com.health.model.TrainingInformation;
import com.health.model.TrainingTopic;

public interface TrainingInformationRespository extends CrudRepository<TrainingInformation,Integer> {

	@Query("select max(trainingId) from TrainingInformation")
	int getNewId();
	
	TrainingInformation findBytitleName(String topicName);
	
}
