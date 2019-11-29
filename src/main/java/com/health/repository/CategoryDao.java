package com.health.repository;

import org.springframework.data.repository.CrudRepository;

import com.health.model.Category;

public interface CategoryDao extends CrudRepository<Category,Integer> {

	Category findBycategoryname(String name);
	Category findByid(int id);
	
	
	
	
	
	

}
