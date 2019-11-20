package com.health.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Testimonial;
import com.health.repository.TestimonialDao;
import com.health.service.testimonialService;





@Service
public class testimonialServiceImpl implements  testimonialService {
	
	
		@Autowired
		public  TestimonialDao testimonialdao;
		
	
		
		
		  @Override 
		  public List<Testimonial> findAll() {
		  
		  List<Testimonial> local=(List<Testimonial>)testimonialdao.findAll();	
		  
		  return local; 
		  
		  }
		
	
	
	
		   
		   @Override
		    public void deleteProduct(Integer id) {

			   testimonialdao.delete(id);
			   //deleteById(id);     
		        
		    }
		   
	/*
	 * @Override public Testimonial getProductById(Integer id){
	 * 
	 * Optional<Testimonial> var=testimonialdao.findOne(id) //findById(id);
	 * 
	 * return var.get();
	 * 
	 * }
	 */
		   
		   
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





		@Override
		public Testimonial getProductById(Integer id) {
			// TODO Auto-generated method stub
			return null;
		}

	
	

}
