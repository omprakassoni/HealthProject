package com.health.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Category;
import com.health.model.Language;
import com.health.model.User;
import com.health.repository.LangaugeRepository;
import com.health.service.LanguageService;


@Service
public class LanguageServiceImp implements LanguageService
{

	@Autowired
	private LangaugeRepository languageRepo;

	@Override
	public List<Language> getAllLanguages() {
		// TODO Auto-generated method stub
		return languageRepo.findAll();
		
	}

	@Override
	public int getnewLanId() {
		// TODO Auto-generated method stub
		try {
			return languageRepo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public Language getByLanName(String langName) {
		// TODO Auto-generated method stub
		return languageRepo.findBylangName(langName);
		
	}

	@Override
	public Language getById(int lanId) {
		// TODO Auto-generated method stub
		Optional<Language> local=languageRepo.findById(lanId);
		
		return local.get();
	}

	@Override
	public void save(Language lan) {
		// TODO Auto-generated method stub
		languageRepo.save(lan);
		
	}
	
	
	
	/*
	 * @Transactional public Boolean findByExcludeLanguage(String languageName) {
	 * int lanNames=languagedao.findByExcludeLanguage(languageName);
	 * 
	 * 
	 * if(lanNames >0) { return true;
	 * 
	 * }else { return false; } }
	 */
	
}