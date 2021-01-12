package com.health.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.repository.query.Param;

import com.health.model.TraineeInformation;
import com.health.model.TrainingInformation;
import com.health.model.TrainingTopic;

public interface TrainingInformationService {

	int getNewId();
	
	void save(TrainingInformation temp);
	
	void addTrainee(TrainingInformation training,Set<TraineeInformation> trainee); 
	
	List<TrainingInformation> findAll();
	
	TrainingInformation getById(int id);
	
	TrainingInformation findByTopicName(String topicName);
	
	
}
