package com.health.service;

import java.util.List;

import com.health.model.Consultant;



public interface ConsultantService {
	
	List<Consultant> findAll();     // in use
	
    void deleteProduct(Integer id);     
    
    Consultant findById(int id);    // in use

	Boolean UpdateConsalantant(String description,String name, String uploadVideo,int consalantant_id);

	void save(Consultant consult);   // in use
	
	int getNewConsultantId();       // in use
	

}
