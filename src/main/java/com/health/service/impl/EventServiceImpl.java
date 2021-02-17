package com.health.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Event;
import com.health.model.User;
import com.health.repository.EventRepository;
import com.health.service.EventService;

@Service
public class EventServiceImpl implements EventService {


	@Autowired
	private EventRepository eventRepo;


	@Override
	public List<Event> findAll() {

		List<Event> local = (List<Event>) eventRepo.getAllEvent();
		return local;

	}

	@Override
	public void deleteProduct(Integer id) {

		eventRepo.deleteById(id);

	}



	@Override
	@Transactional
	public Boolean UpdateEvent(String eventname,Date date,Date end, String description,String venuename, String contactperson,String contactnumber,String email,int id) {

//       int status= eventRepo.UpdateEvent(eventname, date,end, description, venuename, contactperson,contactnumber,email, id);
//
//	  System.err.println(status);
//
//	  if(status>0) { return true; }
//	  else { return false; }
		return true;

	}

	@Override
	public Event findById(int id) {
		// TODO Auto-generated method stub
		Optional<Event> local=eventRepo.findById(id);
		return local.get();
	}

	@Override
	public int getNewEventId() {
		// TODO Auto-generated method stub
		try {
			return eventRepo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public void save(Event event) {
		// TODO Auto-generated method stub
		eventRepo.save(event);
	}

	@Override
	public List<Event> findByUser(User usr) {
		// TODO Auto-generated method stub
		return eventRepo.findByuser(usr);
	}




}
