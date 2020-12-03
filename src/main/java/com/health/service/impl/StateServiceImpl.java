package com.health.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.District;
import com.health.model.State;
import com.health.repository.StateRepository;
import com.health.service.StateService;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository stateRepo;
	@Override
	public void save(State state) {
		// TODO Auto-generated method stub
		stateRepo.save(state);
	}

	@Override
	public State findById(int id) {
		// TODO Auto-generated method stub
		Optional<State> local=stateRepo.findById(id);
		return local.get();
	}

	@Override
	public List<State> findAll() {
		// TODO Auto-generated method stub
		List<State> local=(List<State>) stateRepo.findAll();
		return local;
	}

	@Override
	public State addStateToDistrict(State state, Set<District> districts) {
		// TODO Auto-generated method stub
		
		state.getDistricts().addAll(districts);
		stateRepo.save(state);
		
		return null;
	}

}
