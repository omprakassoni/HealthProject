package com.health.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.health.model.TraineeInformation;

public interface TraineeInformationRepository extends CrudRepository<TraineeInformation,Integer>{
	
	@Query("select max(TraineeId) from TraineeInformation")
	int getNewId();
	
}