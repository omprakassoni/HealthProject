package com.health.service;

import java.util.List;

import com.health.domain.security.UserRole;
import com.health.model.ContributorAssignedTutorial;
import com.health.model.Language;
import com.health.model.TopicCategoryMapping;
import com.health.model.User;

public interface ContributorAssignedTutorialService {
	
	int getNewId();
	
	void save(ContributorAssignedTutorial con);
	
	//ContributorAssignedTutorial findByUserTopicCatLan(User usr,TopicCategoryMapping topicCat,Language lan);
	
	//List<ContributorAssignedTutorial> findAllByUser(User user);
	
	List<ContributorAssignedTutorial> findAll();
	
	List<ContributorAssignedTutorial> findAllByTopicCat(List<TopicCategoryMapping> topCat);
	
	List<ContributorAssignedTutorial> findByTopicCat(TopicCategoryMapping topCat);
	
	List<ContributorAssignedTutorial> findAllByLan(Language lan);
	
	List<ContributorAssignedTutorial> findByTopicCatLan(List<TopicCategoryMapping> topCat, List<UserRole> usrRole);
	
	List<ContributorAssignedTutorial> findAllByTopicCatAndLanViewPart(List<TopicCategoryMapping> topCat,Language lan);
	
	ContributorAssignedTutorial findByTopicCatAndLanViewPart(TopicCategoryMapping topCat,Language lan);
	
	ContributorAssignedTutorial findById(int id);
}
