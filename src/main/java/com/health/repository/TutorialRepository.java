package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.health.model.Category;
import com.health.model.ContributorAssignedTutorial;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.Language;
import com.health.model.Topic;


public interface TutorialRepository extends CrudRepository<Tutorial, Integer> {

	
	@Query("select max(tutorialId) from Tutorial")
	int getNewId();
	
	List<Tutorial> findAllByconAssignedTutorial(ContributorAssignedTutorial con);
	
	List<Tutorial> findAllBystatus(boolean status);
	

}