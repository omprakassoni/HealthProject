package com.health.service;

import java.sql.Date;
import java.util.List;

import com.health.model.Event;
import com.health.model.User;



public interface EventService {

	List<Event> findAll();    // in use

	void deleteProduct(Integer id);

	Event findById(int id);   //  in use

	Boolean UpdateEvent(String eventname,Date date,Date end, String description,String venuename, String contactperson,String contactnumber,String email,int id);

	int getNewEventId();       // in use

	void save(Event event);   // in use

	List<Event> findByUser(User usr);

	Event getById(int id);



}
