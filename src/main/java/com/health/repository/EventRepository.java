package com.health.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.health.model.Event;
import com.health.model.Testimonial;
import com.health.model.User;

public interface EventRepository extends  CrudRepository<Event, Integer> {
	
	@Query("select max(eventId) from Event")
	int getNewId();
	
	@Query("from Event e order by e.startDate desc")  // fetching list of event 
	List<Event> getAllEvent();
	
	List<Event> findByuser(User usr);
	


	
}
