package com.health.service;

import java.util.List;
import java.util.Set;

import com.health.model.City;
import com.health.model.District;
import com.health.model.State;



public interface DistrictService {

	void save(District dist);
	
	District findById(int id);
	
	List<District> findAll();
	
	List<District> findAllByState(State state);
	
	District addDistrictToCity(District dist, Set<City> cities);
}
