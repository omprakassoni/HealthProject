package com.health.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Event;



public interface EventDao extends  CrudRepository<Event, Integer> {
	
	@Modifying
	@Query("update Event set  eventname=?1 ,date=?2, description=?3,venuename=?4,contactperson=?5,contactnumber=?6,email=?7 where id=?8")
	int UpdateEvent(String eventname,String date,String description,String venuename,String contactperson,String contactnumber,String email,int id);

}
