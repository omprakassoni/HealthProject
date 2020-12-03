package com.health.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.health.model.Language;


public interface LangaugeRepository extends JpaRepository<Language,Integer> {

//	Language findBylanguageName(String name);
//
//	@Query("from language u where u.languageName=?1")
//	ArrayList<Language> findByExcludeLanguages(String language);

	@Query("select max(lanId) from Language")
	int getNewId();
	
	Language findBylangName(String langName);

}
