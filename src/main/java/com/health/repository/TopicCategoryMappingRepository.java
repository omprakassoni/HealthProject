package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Category;
import com.health.model.Topic;
import com.health.model.TopicCategoryMapping;


public interface TopicCategoryMappingRepository extends CrudRepository<TopicCategoryMapping, Integer> {

	@Query("select max(topicCategoryId) from TopicCategoryMapping")
	int getNewId();
	
	List<TopicCategoryMapping> findAllBycat(Category cat);
	
	@Query("from TopicCategoryMapping where cat=?1 and topic=?2")
	TopicCategoryMapping findBycatAndtopic(Category cat,Topic topic); 
	
	
}
