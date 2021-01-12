package com.health.service;

import java.util.List;
import java.util.Set;


import com.health.model.TraineeInformation;
import com.health.model.TrainingInformation;


public interface TraineeInformationService {

	int getNewId();
	
	List<TraineeInformation> findAll();
	
	List<TraineeInformation> findAllBytraineeInfos(TrainingInformation trainingId);
	
}
