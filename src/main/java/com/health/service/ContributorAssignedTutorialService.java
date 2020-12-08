package com.health.service;

import java.util.List;

import com.health.model.ContributorAssignedTutorial;
import com.health.model.Language;
import com.health.model.TopicCategoryMapping;
import com.health.model.User;

public interface ContributorAssignedTutorialService {
	
	int getNewId();
	
	ContributorAssignedTutorial findByUserTopicCatLan(User usr,TopicCategoryMapping topicCat,Language lan);
	
	List<ContributorAssignedTutorial> findAllByUser(User user);
}
