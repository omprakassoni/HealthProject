package com.health.service;

import java.util.List;

import com.health.model.Category;
import com.health.model.Event;

public interface CategoryService {
	
	
	List<Category> findAll();
	
	Category findBycategoryname(String name);
	
    void deleteProduct(Integer id);

    Category getProductById(int id);
    
    
    Category findByid(int id);

	Category findByid(String id);
	
	Boolean updateCategory(String description,int id);
	
    
    
}
