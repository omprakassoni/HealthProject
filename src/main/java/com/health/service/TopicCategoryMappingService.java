package com.health.service;

import java.util.List;

import com.health.model.Category;
import com.health.model.Topic;
import com.health.model.TopicCategoryMapping;

public interface TopicCategoryMappingService {

	void save(TopicCategoryMapping local);
	
	int getNewId();
	
	List<TopicCategoryMapping> findAllByCategory(Category cat);
	
	TopicCategoryMapping findAllByCategoryAndTopic(Category cat,Topic topic);
}

