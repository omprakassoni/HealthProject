package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.PostQuestionaire;
import com.health.model.User;
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

	@Override
	public List<PostQuestionaire> findAll() {
		// TODO Auto-generated method stub
		return (List<PostQuestionaire>) repo.findAll();
	}

	@Override
	public List<PostQuestionaire> findByUser(User user) {

		return repo.findByUser(user);
	}
}
