package com.health.service;

import java.sql.Date;
import java.util.List;

import com.health.model.Event;



public interface EventService {
	
	List<Event> findAll();
	void deleteProduct(Integer id);
	  
	  
	Event getProductById(int id);
	  

	Boolean UpdateEvent(String eventname,Date date,Date end, String description,String venuename, String contactperson,String contactnumber,String email,int id);


 

}
