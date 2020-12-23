package com.health.service;

import com.health.model.FeedbackForm;
import com.health.model.FeedbackMasterTrainer;

public interface FeedBackMasterTrainerService {


	int getNewId();
	
	void save(FeedbackMasterTrainer temp);

}