package com.health.service;

import java.util.List;

import com.health.model.Category;
import com.health.model.ContributorAssignedTutorial;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.Language;
import com.health.model.Topic;

public interface TutorialService {


	List<Tutorial> findAll();

	int getNewId();
	
	List<Tutorial> findAllByContributorAssignedTutorial(ContributorAssignedTutorial con);

	void save(Tutorial tut);
	
	Tutorial getById(int id);

}