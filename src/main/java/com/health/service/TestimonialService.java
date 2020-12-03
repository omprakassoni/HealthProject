package com.health.service;

import java.util.List;

import com.health.model.Testimonial;

public interface TestimonialService {
	
	
	List<Testimonial> findAll();   // in use
	
    void deleteProduct(Integer id);
    
    Testimonial findById(int id);   // in use
    
	Boolean updateTestimonial(String description,String name, String uploadVideo,int consalantant_id);
	
	int getNewTestimonialId();
	
	void save(Testimonial temp);   // in use
	
}
