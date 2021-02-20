package com.health.service;

import java.util.List;

import com.health.model.Consultant;
import com.health.model.User;



public interface ConsultantService {
	
	List<Consultant> findAll();     // in use
	
    void deleteProduct(Integer id);     
    
    Consultant findById(int id);    // in use

	Boolean UpdateConsalantant(String description,String name, String uploadVideo,int consalantant_id);

	void save(Consultant consult);   // in use
	
	int getNewConsultantId();       // in use
	
	Consultant findByUser(User usr);
	
	List<Consultant> findByOnHome(boolean value);
	

}
