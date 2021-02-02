package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Brouchure;

public interface BrouchureRepository extends CrudRepository<Brouchure, Integer> {

	@Query("select max(id) from Brouchure")
	int getNewId();
	
	List<Brouchure> findAllByshowOnHomepage(boolean value);
}
