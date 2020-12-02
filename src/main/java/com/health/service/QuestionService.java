package com.health.service;

import com.health.model.Question;

public interface QuestionService {

	int getNewId();
	
	void save(Question ques);
	
	Question findById(int id);
}
