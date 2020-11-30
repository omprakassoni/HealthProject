package com.health.service;

import java.util.List;

import com.health.model.Testimonial;

public interface TestimonialService {
	
	
	List<Testimonial> findAll();
	
	
    void deleteProduct(Integer id);
    
    Testimonial getProductById(int id);
    

	Boolean updateTestimonial(String description,String name, String uploadVideo,int consalantant_id);
	

}
