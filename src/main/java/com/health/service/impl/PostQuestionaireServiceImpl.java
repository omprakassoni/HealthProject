package com.health.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.PostQuestionaire;
import com.health.repository.PostQuestionaireRepository;
import com.health.service.PostQuestionaireService;

@Service
public class PostQuestionaireServiceImpl implements PostQuestionaireService {

	@Autowired
	private PostQuestionaireRepository repo;

	@Override
	public int getNewCatId() {
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
	public void save(PostQuestionaire temp) {
		// TODO Auto-generated method stub
		repo.save(temp);
	}
}
