package com.health.repository;

import org.springframework.data.repository.CrudRepository;

import com.health.model.Category;
import com.health.model.language;

public interface languagedao extends CrudRepository<language,Integer> {
	
	  

		language findBylanguageName(String name);
	

}
