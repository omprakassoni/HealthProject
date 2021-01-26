package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Consultant;
import com.health.model.User;



public interface ConsultantRepository extends CrudRepository<Consultant,Integer>{

	@Query("select max(consultantId) from Consultant")
	int getNewId();

	Consultant findByuser(User usr);


}

