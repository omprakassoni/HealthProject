package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Category;
import com.health.model.topic;

public interface CategoryDao extends CrudRepository<Category,Integer>
{

	Category findBycategoryname(String name);	
	Category findByid(int id);
	List<Category> findBystatus(int status);
	
	
	/* ORDER BY categoryname Asc */
	
	
	  
}
