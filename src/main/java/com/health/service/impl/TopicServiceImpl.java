package com.health.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Topic;
import com.health.repository.TopicRepository;
import com.health.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicRepo;
	
	@Override
	public int getNewTopicId() {
		// TODO Auto-generated method stub
		try {
			return topicRepo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public Topic findBytopicName(String topic) {
		// TODO Auto-generated method stub
		return topicRepo.findBytopicName(topic);
	}

	@Override
	public Topic findById(int id) {
		// TODO Auto-generated method stub
		try {
			Optional<Topic> local=topicRepo.findById(id);
			return local.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Topic> findAll() {
		// TODO Auto-generated method stub
		return (List<Topic>) topicRepo.findAll();
	}

	@Override
	public void save(Topic topic) {
		// TODO Auto-generated method stub
		topicRepo.save(topic);
	}

}
