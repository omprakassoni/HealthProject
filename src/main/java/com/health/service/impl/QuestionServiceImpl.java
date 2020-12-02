package com.health.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Question;
import com.health.repository.QuestionRepository;
import com.health.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepo;
	
	@Override
	public int getNewId() {
		// TODO Auto-generated method stub
		try {
			return questionRepo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public void save(Question ques) {
		// TODO Auto-generated method stub
		questionRepo.save(ques);
	}

	@Override
	public Question findById(int id) {
		// TODO Auto-generated method stub
		Optional<Question> local=questionRepo.findById(id);
		return local.get();
	}

	
}
