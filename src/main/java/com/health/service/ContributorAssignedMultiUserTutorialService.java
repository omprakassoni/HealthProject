package com.health.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.health.model.ContributorAssignedMultiUserTutorial;
import com.health.model.User;


public interface ContributorAssignedMultiUserTutorialService {

	void save(ContributorAssignedMultiUserTutorial con);
	
	int getNewId();
	
	List<ContributorAssignedMultiUserTutorial> getAllByuser(User usr);
}
