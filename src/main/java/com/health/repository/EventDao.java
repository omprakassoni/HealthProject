package com.health.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.health.model.Event;
import com.health.model.Testimonial;



public interface EventDao extends  CrudRepository<Event, Integer> {
	
	@Modifying
	@Query("update Event set  eventname=?1 ,date=?2,endDate=?3, description=?4,venuename=?5,contactperson=?6,contactnumber=?7,email=?8 where id=?9")
	int UpdateEvent(String eventname,Date date,Date end,String description,String venuename,String contactperson,String contactnumber,String email,int id);

	
	@Query("from Event e order by e.date desc")  // fetching list of event 
	List<Event> getAllEvent();
	
	
	@Query("from Event  order by timedate desc")
	List<Event> findBylatestdate();


	/*
	 * @Modifying
	 * 
	 * @Query("select eventname,date,description,venuename,contactperson,email from Event where ORDER BY  DES"
	 * ) List<Event> findByEvent();
	 */
	
}
