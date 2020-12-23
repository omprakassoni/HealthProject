package com.health.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.FeedbackMasterTrainer;
import com.health.repository.FeedBackRepository;
import com.health.service.FeedBackMasterTrainerService;

@Service
public class FeedBackMasterTrainerServiceImpl implements FeedBackMasterTrainerService {

	@Autowired
	private FeedBackRepository feedRepo;
	
	@Override
	public int getNewId() {
		// TODO Auto-generated method stub
		try {
			return feedRepo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public void save(FeedbackMasterTrainer temp) {
		// TODO Auto-generated method stub
		feedRepo.save(temp);
	}

}
