package com.health.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.health.model.language;

public interface languagedao extends JpaRepository<language,Integer> {

	language findBylanguageName(String name);

	@Query("from language u where u.languageName=?1")
	ArrayList<language> findByExcludeLanguages(String language);



	/*
	 * @Query("from language u where u.languageName =?1") ArrayList<language>
	 * findBylanName(Category category);
	 *
	 */

	/* @Query("from language where languageName") */


}
