package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.IndianLanguage;
import com.health.repository.IndianLanguageRepository;
import com.health.service.IndianLanguageService;

@Service
public class IndianLanguageServiceImpl implements IndianLanguageService{

	@Autowired
	private IndianLanguageRepository repo;

	@Override
	public int getNewId() {
		// TODO Auto-generated method stub
		try {
			return repo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public IndianLanguage findByName(String lanName) {
		// TODO Auto-generated method stub
		try {
			return repo.findBylanName(lanName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<IndianLanguage> findAll() {
		// TODO Auto-generated method stub
		return (List<IndianLanguage>) repo.findAll();
	}
}
