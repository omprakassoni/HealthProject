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

/**
 * This Interface Extend CrudRepository to handle all database operation related to Tutorial object
 * @author om prakash soni
 * @version 1.0
 *
 */
public interface TutorialRepository extends CrudRepository<Tutorial, Integer> {

	/**
	 * Find the next unique id for the object
	 * @return primitive integer value
	 */
	@Query("select max(tutorialId) from Tutorial")
	int getNewId();
	
	/**
	 * List of Tutorial Object given ContributorAssignedTutorial object
	 * @param con ContributorAssignedTutorial object
	 * @return list of Tutorial object
	 */
	List<Tutorial> findAllByconAssignedTutorial(ContributorAssignedTutorial con);
	
	/**
	 * List of Tutorial Object given status value
	 * @param status boolean value
	 * @return list of Tutorial object
	 */
	List<Tutorial> findAllBystatus(boolean status);
	

}