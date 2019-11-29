package com.health.repository;

import org.springframework.data.repository.CrudRepository;

import com.health.model.Category;
import com.health.model.Tutorial;

public interface TutorialDao extends CrudRepository<Tutorial, Integer>{
	

	Tutorial findBylanguage(String name);
	
	
	

	
}
