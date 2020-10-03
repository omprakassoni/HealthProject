package com.health.repository;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.Modifying;
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
	 
	 
	 
	 
@Modifying
@Query("update traineeInformation set  name=?1,age=?2, mobileNumber=?3 ,address=?4,organization=?5,experience=?6,premark=?7,postmark=?8,aadharNumber=?9 where id=?10")
int updateTrainingInfo(String name,String age,String mobilenumber,String address,String org,String exp,String pre,String post,String aadhar,int id);



@Modifying
@Query("from traineeInformation u where u.address=?1 or organization=?2")
List<traineeInformation> findByTrainee(String address,String org);





}