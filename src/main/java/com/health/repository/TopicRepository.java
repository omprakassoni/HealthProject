package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Category;
import com.health.model.Topic;

public interface TopicRepository extends CrudRepository<Topic , Integer>{
	
//	Topic findBytopicname(String topic);
//
//	@Query("from topic u where u.category=?1") 
//	List<Topic> findByCategory(Category category);
	 
	@Query("select max(topicId) from Topic")
	int getNewId();
	
	Topic findBytopicName(String topicName);
			
}
