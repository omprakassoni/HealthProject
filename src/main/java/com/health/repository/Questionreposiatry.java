package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Category;
import com.health.model.Question;
import com.health.model.Tutorial;
import com.health.model.category_Tutorial;
import com.health.model.topic;

public interface Questionreposiatry extends CrudRepository<Question, Integer> {
	
	
	  @Query("from Question u where u.topic=?1")
	  List<Question> findByTutorial(topic topic);
	  
	  

}
