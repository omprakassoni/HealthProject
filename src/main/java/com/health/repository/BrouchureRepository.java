package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Brouchure;
import com.health.model.TopicCategoryMapping;

public interface BrouchureRepository extends CrudRepository<Brouchure, Integer> {

	@Query("select max(id) from Brouchure")
	int getNewId();

	List<Brouchure> findAllByshowOnHomepage(boolean value);

	@Query("from Brouchure where topicCatId = ?1")
	List<Brouchure> findByTopicCat(TopicCategoryMapping topicCat);
}
