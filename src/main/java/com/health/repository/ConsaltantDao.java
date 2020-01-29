package com.health.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Consaltantant;



public interface ConsaltantDao extends CrudRepository<Consaltantant,Integer>{
	
	
	@Modifying
	@Query("update Consaltantant set  descriptionConsaltant=?1 ,nameConsaltant=?2, uploadConsaltantImage=?3 where id=?4")
	int updateconsalantant(String description,String name, String uploadVideo,int id);
	
	
}
