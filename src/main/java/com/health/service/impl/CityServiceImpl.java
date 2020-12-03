package com.health.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.City;
import com.health.model.District;
import com.health.repository.CityRepository;
import com.health.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepo;
	
	@Override
	public void save(City city) {
		// TODO Auto-generated method stub
		cityRepo.save(city);
	}

	@Override
	public City findById(int id) {
		// TODO Auto-generated method stub
		Optional<City> local=cityRepo.findById(id);
		return local.get();
	}

	@Override
	public List<City> findAll() {
		// TODO Auto-generated method stub
		List<City> local=(List<City>) cityRepo.findAll();
		return local;
	}

	@Override
	public List<City> findAllByDistrict(District district) {
		// TODO Auto-generated method stub
		List<City> local=cityRepo.findAllBydistrict(district);
		return local;
	}

}
