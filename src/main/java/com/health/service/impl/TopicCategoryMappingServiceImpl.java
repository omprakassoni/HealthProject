package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Category;
import com.health.model.Topic;
import com.health.model.TopicCategoryMapping;
import com.health.repository.TopicCategoryMappingRepository;
import com.health.service.TopicCategoryMappingService;

@Service
public class TopicCategoryMappingServiceImpl implements TopicCategoryMappingService {

	@Autowired
	private TopicCategoryMappingRepository topicCatRepo;
	
	@Override
	public void save(TopicCategoryMapping local) {
		// TODO Auto-generated method stub
		topicCatRepo.save(local);
		
	}

	@Override
	public int getNewId() {
		// TODO Auto-generated method stub
		try {
			return topicCatRepo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public List<TopicCategoryMapping> findAllByCategory(Category cat) {
		// TODO Auto-generated method stub
		return topicCatRepo.findAllBycat(cat);
	}

	@Override
	public TopicCategoryMapping findAllByCategoryAndTopic(Category cat, Topic topic) {
		// TODO Auto-generated method stub
		return topicCatRepo.findAllBycatAndtopic(cat, topic);
	}

	
}
