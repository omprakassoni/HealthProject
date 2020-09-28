package com.health.repository;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.TraningInformation;
import com.health.model.User;
import com.health.model.profileInformation;
import com.health.model.traineeInformation;


public interface traineeProfileDao extends CrudRepository<traineeInformation,Integer>
{
	
//	@Query("select COUNT(*) from traineeInformation u where u.aadharNumber=?1") 
	//long  traineeInformation findByaadharNumber(String addharid);
	 long countByaadharNumber(String aadharNumber); 	

}