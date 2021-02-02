package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Brouchure;
import com.health.repository.BrouchureRepository;
import com.health.service.BrouchureService;

@Service
public class BrouchureServiceImpl implements BrouchureService{

	@Autowired
	private BrouchureRepository repo;
	
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
	public void save(Brouchure temp) {
		// TODO Auto-generated method stub
		repo.save(temp);
	}

	@Override
	public List<Brouchure> findAll() {
		// TODO Auto-generated method stub
		return (List<Brouchure>) repo.findAll();
	}

	@Override
	public void delete(Brouchure temp) {
		// TODO Auto-generated method stub
		repo.delete(temp);
	}

	@Override
	public List<Brouchure> findByOnHome(boolean value) {
		// TODO Auto-generated method stub
		return repo.findAllByshowOnHomepage(value);
	}

	@Override
	public Brouchure findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}
	
	

}
