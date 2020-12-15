package com.health.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.health.model.TrainingInformation;

public interface TrainingInformationRespository extends CrudRepository<TrainingInformation,Integer> {

	@Query("select max(trainingId) from TrainingInformation")
	int getNewId();
}
