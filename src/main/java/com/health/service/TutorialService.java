package com.health.service;

import java.util.List;

import com.health.model.ContributorAssignedTutorial;
import com.health.model.Tutorial;

public interface TutorialService {


	List<Tutorial> findAll();

	int getNewId();

	List<Tutorial> findAllByContributorAssignedTutorial(ContributorAssignedTutorial con);

	List<Tutorial> findAllByContributorAssignedTutorialList(List<ContributorAssignedTutorial> con);

	void save(Tutorial tut);

	Tutorial getById(int id);

}