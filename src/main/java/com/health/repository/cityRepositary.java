package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.City;
import com.health.model.District;
import com.health.model.state;

public interface cityRepositary extends CrudRepository<City, Integer>
{
	

	  @Query("from City where district=?1")
	  List<City> findBydistrict(District district);
	  
	  

}
