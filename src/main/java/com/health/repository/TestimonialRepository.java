package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Testimonial;

public interface TestimonialRepository extends CrudRepository<Testimonial, Integer> {

	@Query("select max(testimonialId) from Testimonial")
	int getNewId();
	
	List<Testimonial> findByapproved(boolean value);

}
