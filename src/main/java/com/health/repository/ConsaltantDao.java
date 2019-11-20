package com.health.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Consaltantant;



public interface ConsaltantDao extends CrudRepository<Consaltantant,Integer>{
	
	
	@Modifying
	@Query("update Consaltantant set  descriptionConsaltant=:description ,nameConsaltant=:name, uploadConsaltantImage=:uploadVideo where id=:id")
	 int updateconsalantant(String description,String name, String uploadVideo,int id);


}
