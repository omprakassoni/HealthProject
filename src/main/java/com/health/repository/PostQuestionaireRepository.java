package com.health.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.PostQuestionaire;

public interface PostQuestionaireRepository extends CrudRepository<PostQuestionaire, Integer>{
	
	@Query("select max(id) from PostQuestionaire")
	int getNewId();
	

}
