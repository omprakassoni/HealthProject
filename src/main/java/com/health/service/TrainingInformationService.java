package com.health.service;

import java.util.List;
import java.util.Set;

import com.health.model.TraineeInformation;
import com.health.model.TrainingInformation;

public interface TrainingInformationService {

	int getNewId();
	
	void save(TrainingInformation temp);
	
	void addTrainee(TrainingInformation training,Set<TraineeInformation> trainee); 
	
	List<TrainingInformation> findAll();
	
	TrainingInformation getById(int id);
	
	TrainingInformation findByTopicName(String topicName);
	
}
