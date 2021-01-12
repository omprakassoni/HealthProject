package com.health.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.TraineeInformation;
import com.health.model.TrainingInformation;
import com.health.model.TrainingTopic;
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

	@Override
	public List<TrainingInformation> findAll() {
		// TODO Auto-generated method stub
		return (List<TrainingInformation>) trainingInfoRepo.findAll();
	}

	@Override
	public TrainingInformation getById(int id) {
		// TODO Auto-generated method stub
		Optional<TrainingInformation> local = trainingInfoRepo.findById(id);
		return local.get();
	}

	@Override
	public TrainingInformation findByTopicName(String topicName) {
		// TODO Auto-generated method stub
		return trainingInfoRepo.findBytitleName(topicName);
	}


	


}