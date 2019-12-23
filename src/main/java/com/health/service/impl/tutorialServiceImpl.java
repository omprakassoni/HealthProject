package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Category;
import com.health.model.Tutorial;
import com.health.repository.TutorialDao;
import com.health.service.tutorialService;

@Service
public class tutorialServiceImpl implements tutorialService {

	@Autowired
	private TutorialDao tutorialDao;
	
	
	@Override
	public List<Tutorial> findAll() {

		List<Tutorial> local = (List<Tutorial>) tutorialDao.findAll();

		return local;

	}
	
	
	
	

}
