package com.health.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.TraineeInformation;
import com.health.model.TrainingInformation;
import com.health.repository.TrainingInformationRespository;
import com.health.service.TrainingInformationService;

@Service
public class TrainingInformationServiceImpl implements TrainingInformationService {

	@Autowired
	private TrainingInformationRespository trainingInfoRepo;
	
	@Override
	public int getNewId() {
		// TODO Auto-generated method stub
		try {
			return trainingInfoRepo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public void save(TrainingInformation temp) {
		// TODO Auto-generated method stub
		trainingInfoRepo.save(temp);
		
	}

	@Override
	public void addTrainee(TrainingInformation training, Set<TraineeInformation> trainee) {
		// TODO Auto-generated method stub
		training.getTraineeInfos().addAll(trainee);
		trainingInfoRepo.save(training);
	}


}