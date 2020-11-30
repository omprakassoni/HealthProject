package com.health.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.health.model.Consultant;

import com.health.repository.ConsultantRepository;

import com.health.service.ConsultantService;


@Service
public class consaltantServiceImpl implements ConsultantService {

	@Autowired
	private ConsultantRepository consaltantdao;

	@Override
	public List<Consultant> findAll() {

		List<Consultant> local = (List<Consultant>) consaltantdao.findAll();

		return local;

	}
	
	@Override
	public void deleteProduct(Integer id){

		
		// consaltantdao.delete(id);
		
		  // version 2.1.7
		consaltantdao.deleteById(id);
																																																																												
	}
//chage the method
	@Override
	
	  public Consultant getProductById(Integer id) {
	  
	 // Consaltantant var = consaltantdao.findOne(id);
	  
	  // version 2.1.7
	  Optional<Consultant> var = consaltantdao.findById(id);
	  
	  return var.get();
	  
	  }
	 
	
	@Transactional																																																							
	public Boolean UpdateConsalantant(String description,String name, String uploadVideo,int id) {
		
		int status=	consaltantdao.updateconsalantant( description,name,uploadVideo,id);
		
		System.err.println(status);
		
		if(status>0) {
			return true;
		}else {
			return false;
		}
	
	}
	
	
    @Override
    public Consultant saveProduct(Consultant product) {
    	
        return consaltantdao.save(product);
    }

	/*
	 * @Override public Consaltantant getProductById(Integer id) { // TODO
	 * Auto-generated method stub return null; }
	 */
	


	
	
	
	
	
}
 

	
	

