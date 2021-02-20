package com.health.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.City;
import com.health.model.District;
import com.health.model.State;
import com.health.repository.DistrictRepository;
import com.health.service.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictRepository distRepo;
	
	@Override
	public void save(District dist) {
		// TODO Auto-generated method stub
		distRepo.save(dist);
	}

	@Override
	public District findById(int id) {
		// TODO Auto-generated method stub
		try {
			Optional<District> local=distRepo.findById(id);
			
			return local.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<District> findAll() {
		// TODO Auto-generated method stub
		List<District> local=(List<District>) distRepo.findAll();
		return local;
	}

	@Override
	public List<District> findAllByState(State state) {
		// TODO Auto-generated method stub
		List<District> local=distRepo.findAllBystate(state);
		return local;
	}

	@Override
	public District addDistrictToCity(District dist, Set<City> cities) {
		// TODO Auto-generated method stub
		dist.getCities().addAll(cities);
		distRepo.save(dist);
		return null;
	}

}
