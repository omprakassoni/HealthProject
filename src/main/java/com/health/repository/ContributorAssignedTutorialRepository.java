package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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
	
//	@Query("from ContributorAssignedTutorial where user=?1 and topicCatId=?2 and lan=?3")
//	ContributorAssignedTutorial findByUserTopicCatLan(User usr,TopicCategoryMapping topicCat,Language lan);
	
	//List<ContributorAssignedTutorial> findAllByuser(User user);
	
	List<ContributorAssignedTutorial> findAllBytopicCatId(TopicCategoryMapping topCat);
	
	List<ContributorAssignedTutorial> findAllBylan(Language lan);
	
	@Query("from ContributorAssignedTutorial where topicCatId=?1 and lan=?2")
	ContributorAssignedTutorial findByTopicCatLan(TopicCategoryMapping topicCat,Language lan);
	
	@Query("from ContributorAssignedTutorial where topicCatId IN (:TopicCat)")
	List<ContributorAssignedTutorial> findByTopicCat(@Param("TopicCat")List<TopicCategoryMapping> topCat);
}

