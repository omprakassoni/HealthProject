package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Consultant;



public interface ConsultantRepository extends CrudRepository<Consultant,Integer>{

	@Query("select max(consultantId) from Consultant")
	int getNewId();

//	@Modifying
//	@Query("update Consaltantant set  descriptionConsaltant=?1 ,nameConsaltant=?2, uploadConsaltantImage=?3 where id=?4")
//	int updateconsalantant(String description,String name, String uploadVideo,int id);
//
//	/*
//	 * here is code consalatant
//	 */
//	@Query("from Consaltantant order by timedate desc")
//	List<Consultant> findBydateConsalant();
//
//	/*
//	 * Here is code for only access three recored from consalatatant table
//	 */
//
//	 @Query("from Consaltantant order by timedate ")
//	 List<Consultant> findByConsaltantantDate();
//
//	 @Query("from Consaltantant c where c.showOnHomepage=?1")
//	 List<Consultant> findByConsultantShowonHomepage(Boolean showOnHomepage);


}

