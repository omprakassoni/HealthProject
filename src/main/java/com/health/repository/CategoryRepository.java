package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Category;

public interface CategoryRepository extends CrudRepository<Category,Integer>{

//	Category findBycatName(String name);
//	Category findBycategoryId(int id);
//	List<Category> findBystatus(int status);
//
//
//	@Modifying
//	@Query("update Category set  catName=?1 where id=?2")
//	int updateCategory(String name,int id);
	


}