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
	
//	@Modifying
//	@Query("update Testimonial set  testimonialName=?1 ,testimoniaqlDescription=?2, uploadTestiminial=?3 where id=?4")
//	int updateTestimonial(String testimonialName,String testimoniaqlDescription, String uploadTestiminial,int id);
//
//
//	@Query("from Testimonial order by timedate desc")
//	List<Testimonial> findBydate();


}
