package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Tutorial;
import com.health.model.commentOnComponent;

public interface commentOnComponentDao extends CrudRepository<commentOnComponent, Integer>
{


	@Query("from commentOnComponent u where u.tutorial=?1")
	List<commentOnComponent> findBytutorial_id(Tutorial tutorial);

	@Query("from commentOnComponent u where u.tutorial=?1 and u.componenenetDeatail=?2")
	List<commentOnComponent> findBytutorialAndComponent(Tutorial tutorial, String commentOnComponent);







}
