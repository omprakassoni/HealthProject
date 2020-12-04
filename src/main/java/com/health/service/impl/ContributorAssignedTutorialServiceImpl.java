package com.health.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.ContributorAssignedTutorial;
import com.health.model.Language;
import com.health.model.TopicCategoryMapping;
import com.health.model.User;
import com.health.repository.ContributorAssignedTutorialRepository;
import com.health.service.ContributorAssignedTutorialService;

@Service
public class ContributorAssignedTutorialServiceImpl implements ContributorAssignedTutorialService{

	@Autowired
	private ContributorAssignedTutorialRepository conRepo;
	
	@Override
	public int getNewId() {
		// TODO Auto-generated method stub
		try {
			return conRepo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public ContributorAssignedTutorial findByUserTopicCatLan(User usr, TopicCategoryMapping topicCat, Language lan) {
		// TODO Auto-generated method stub
		return conRepo.findByUserTopicCatLan(usr, topicCat, lan);
	}

}
