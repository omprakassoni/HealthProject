package com.health.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.TraineeInformation;
import com.health.model.TrainingInformation;
import com.health.repository.TraineeInformationRepository;
import com.health.service.TraineeInformationService;

@Service
public class TraineeInformationServiceImpl implements TraineeInformationService{

	@Autowired
	private TraineeInformationRepository repo;
	
	@Override
	public int getNewId() {
		// TODO Auto-generated method stub
		try {
			return repo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public List<TraineeInformation> findAll() {
		// TODO Auto-generated method stub
		return (List<TraineeInformation>) repo.findAll();
	}

	@Override
	public List<TraineeInformation> findAllBytraineeInfos(TrainingInformation trainingId) {
		// TODO Auto-generated method stub
		return repo.findAllBytraineeInfos(trainingId);
	}




}
