package com.health.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.repository.TrainingTopicRepository;
import com.health.service.TrainingTopicService;

@Service
public class TrainingTopicServiceImpl implements TrainingTopicService {

	@Autowired
	private TrainingTopicRepository trainingTopicRepo;
	@Override
	public int getNewId() {
		// TODO Auto-generated method stub
		try {
			return trainingTopicRepo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

}
