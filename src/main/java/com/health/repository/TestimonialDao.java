package com.health.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Testimonial;

public interface TestimonialDao extends CrudRepository<Testimonial, Integer> {

	
	@Modifying
	@Query("update Testimonial set  testimonialName=:testimonialName ,testimoniaqlDescription=:testimoniaqlDescription, uploadTestiminial=:uploadTestiminial where id=:id")
	 int updateTestimonial(String testimonialName,String testimoniaqlDescription, String uploadTestiminial,int id);
	

	
}
