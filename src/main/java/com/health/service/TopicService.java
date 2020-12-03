package com.health.service;

import com.health.model.Topic;

public interface TopicService {

	int getNewTopicId();
	
	Topic findBytopicName(String topic);
	
	Topic findById(int id);
}
