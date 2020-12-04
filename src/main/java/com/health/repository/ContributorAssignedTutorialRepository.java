package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.ContributorAssignedTutorial;
import com.health.model.Language;
import com.health.model.Topic;
import com.health.model.TopicCategoryMapping;
import com.health.model.User;


public interface ContributorAssignedTutorialRepository extends CrudRepository<ContributorAssignedTutorial, Integer> {

	@Query("select max(id) from ContributorAssignedTutorial")
	int getNewId();
	
	@Query("from ContributorAssignedTutorial where user=?1 and topicCatId=?2 and lan=?3")
	ContributorAssignedTutorial findByUserTopicCatLan(User usr,TopicCategoryMapping topicCat,Language lan);
	
}
