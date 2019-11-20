package com.health.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Event;



public interface EventDao extends  CrudRepository<Event, Integer> {
	

	
	@Modifying
	@Query("update Event set  eventname=:eventname ,date=:date, description=:description,venuename=:venuename,contactperson=:contactperson,contactnumber=:contactnumber,email=:email where id=:id")
	int UpdateEvent(String eventname,String date, String description,String venuename, String contactperson, String contactnumber,String email,int id);

	
}
