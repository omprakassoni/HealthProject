package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.FeedbackMasterTrainer;
import com.health.model.User;
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

	@Override
	public List<FeedbackMasterTrainer> findByUser(User user) {
		// TODO Auto-generated method stub
		return feedRepo.findByUser(user);
	}

	@Override
	public List<FeedbackMasterTrainer> findAll() {
		// TODO Auto-generated method stub
		return (List<FeedbackMasterTrainer>) feedRepo.findAll();
	}

}
