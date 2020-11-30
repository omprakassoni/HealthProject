package com.health.repository;

import org.springframework.data.repository.CrudRepository;

import com.health.model.ContactForm;
import com.health.model.feedbackMasterTrainer;

public interface ContactFormRepository extends CrudRepository<ContactForm, Integer>{
	
	

}
