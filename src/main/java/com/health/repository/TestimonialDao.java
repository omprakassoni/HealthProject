package com.health.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Testimonial;

public interface TestimonialDao extends CrudRepository<Testimonial, Integer> {

	
	@Modifying
	@Query("update Testimonial set  testimonialName=?1 ,testimoniaqlDescription=?2, uploadTestiminial=?3 where id=?4")
	 int updateTestimonial(String testimonialName,String testimoniaqlDescription, String uploadTestiminial,int id);
	
	
	
}
