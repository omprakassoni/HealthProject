package com.health.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Category;


import com.health.repository.CategoryRepository;
import com.health.service.CategoryService;


@Service
public class CatgoryServiceImpl implements CategoryService {

	@Autowired 
	private CategoryRepository  categoryRepo;
	
	@Override
	public List<Category> findAll() {

		return (List<Category>) categoryRepo.findAll();


	}
	
	@Override
	public Category findBycategoryname(String name) {

		Category local =  categoryRepo.findBycatName(name);

		return local;

	}
	
	@Override
	public void deleteProduct(Integer id){

		categoryRepo.deleteById(id);																																																																									
	}
	
	   
	@Override
	@Transactional																																																							
	public Boolean updateCategory(String testimonialName,int id) {
			
//			int status=	categoryRepo.updateCategory(testimonialName,id);
//
//			
//			if(status>0) {
//				return true;
//			}else {
				return false;
			
		
	}
		  
	  
	@Override 
	public Category findByid(int id){
	  
		Optional<Category> var=categoryRepo.findById(id);
		return var.get();
	  
	 }

	@Override
	public int getNewCatId() {
		
		try {
			return categoryRepo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1; 
		}
		
	}

	@Override
	public Category save(Category cat) {
		// TODO Auto-generated method stub
		categoryRepo.save(cat);
		return null;
	}

	  
	
	

}
