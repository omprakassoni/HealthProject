package com.health.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Event;
import com.health.model.Testimonial;

import com.health.repository.EventRepository;
import com.health.service.EventService;




@Service
public class eventServiceImpl implements EventService {
	

	@Autowired
	private EventRepository eventdao;

	
	@Override
	public List<Event> findAll() {
		
		List<Event> local = (List<Event>) eventdao.findAll();
		return local;
	}
	
	  @Override public void deleteProduct(Integer id) {  
	  //eventdao.delete(id);
	  // version 2.1.7
	  eventdao.deleteById(id);
	  
	  }
		
	  @Override 
	  public Event getProductById(int id){
	  
	 //  Event var=eventdao.findOne(id);
	  
	  // version 2.1.7
	  Optional<Event> var=eventdao.findById(id);
	  return var.get();
	  
	  }
 
	  @Override
	  @Transactional
	  public Boolean UpdateEvent(String eventname,Date date,Date end, String description,String venuename, String contactperson,String contactnumber,String email,int id) {
	  
       int status= eventdao.UpdateEvent(eventname, date,end, description, venuename, contactperson,contactnumber,email, id);

	  System.err.println(status);
	  
	  if(status>0) { return true; }
	  else { return false; }
	  
	  }


	

}
