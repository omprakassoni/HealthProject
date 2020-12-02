package com.health.service;

import java.util.List;

import com.health.model.Category;
import com.health.model.Event;

public interface CategoryService {
	
	
	List<Category> findAll();
	
	Category findBycategoryname(String name);
	
    void deleteProduct(Integer id);
   
    Category findByid(int id);
	
	Boolean updateCategory(String description,int id);
	
	int getNewCatId();
	
	Category save(Category cat);
	
    
    
}
