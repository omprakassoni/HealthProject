package com.health.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Testimonial;

import com.health.repository.TestimonialRepository;
import com.health.service.TestimonialService;






@Service
public class testimonialServiceImpl implements  TestimonialService {
	
	
		@Autowired
		public  TestimonialRepository testimonialdao;
		
	
		
		
		  @Override 
		  public List<Testimonial> findAll() {
		  
		  List<Testimonial> local=(List<Testimonial>)testimonialdao.findAll();	
		  
		  return local; 
		  
		  }
		
	
	
	
		   
		   @Override
		    public void deleteProduct(Integer id) {

			   testimonialdao.deleteById(id);
			   //deleteById(id);     
		        
		    }
		   
	
	  @Override 
	  public Testimonial getProductById(int id){
	  
	 //  Testimonial var=testimonialdao.findOne(id) ;//findById(id);
	  
		  // version 2.1.7
	  Optional<Testimonial> var=testimonialdao.findById(id) ;//findById(id);
	  
	  return var.get();
	  
	  }
	 
		   
		   
		   @Override
			@Transactional																																																							
			public Boolean updateTestimonial(String testimonialName,String testimoniaqlDescription, String uploadTestiminial,int id) {
				
				int status=	testimonialdao.updateTestimonial(testimonialName, testimoniaqlDescription, uploadTestiminial, id);
	
				System.err.println(status);
				
				if(status>0) {
					return true;
				}else {
					return false;
				}
			
			}






	
	

}
