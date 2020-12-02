package com.health.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.model.Category;
import com.health.model.TopicCategoryMapping;
import com.health.service.CategoryService;
import com.health.service.TopicCategoryMappingService;
import com.health.service.TopicService;

@Controller
public class AjaxController{
	
	@Autowired
	private CategoryService catService;
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private TopicCategoryMappingService topicCatService;
	
	@RequestMapping("/loadTopicByCategory")
	public @ResponseBody HashMap<Integer, String> getTopicByCategory(@RequestParam(value = "id") int id) {

		HashMap<Integer,String> topicName=new HashMap<>();

		Category cat = catService.findByid(id);

		List<TopicCategoryMapping> local = topicCatService.findAllByCategory(cat) ;

		for(TopicCategoryMapping temp : local) {

			topicName.put(temp.getTopic().getTopicId(), temp.getTopic().getTopicName());
		}
		return topicName;

	}
}
