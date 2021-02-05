package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Carousel;

public interface CarouselRepository extends CrudRepository<Carousel, Integer> {

	@Query("select max(id) from Carousel")
	int getNewId();
	
	List<Carousel> findAllByshowOnHomepage(boolean value);
}
