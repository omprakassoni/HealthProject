package com.health.service;

import com.health.model.LogManegement;

public interface LogMangementService {

	int getNewId();
	
	void save(LogManegement log);
}
