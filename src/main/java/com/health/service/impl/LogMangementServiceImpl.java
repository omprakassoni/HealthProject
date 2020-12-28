package com.health.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.LogManegement;
import com.health.repository.LogMangementRepository;
import com.health.service.LogMangementService;

@Service
public class LogMangementServiceImpl implements LogMangementService{

	@Autowired
	private LogMangementRepository logRepo;
	
	@Override
	public int getNewId() {
		// TODO Auto-generated method stub
		try {
			return logRepo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public void save(LogManegement log) {
		// TODO Auto-generated method stub
		logRepo.save(log);
	}
	
	

}
