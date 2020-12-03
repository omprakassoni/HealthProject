package com.health.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Testimonial;

import com.health.repository.TestimonialRepository;
import com.health.service.TestimonialService;

@Service
public class TestimonialServiceImpl implements  TestimonialService {

	@Autowired
	private TestimonialRepository testRepo;
	
	@Override
	public List<Testimonial> findAll() {
		// TODO Auto-generated method stub
		List<Testimonial> test=(List<Testimonial>) testRepo.findAll();
		return test;
	}

	@Override
	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Testimonial findById(int id) {
		// TODO Auto-generated method stub
		Optional<Testimonial> local=testRepo.findById(id);
		return local.get();
	}

	@Override
	public Boolean updateTestimonial(String description, String name, String uploadVideo, int consalantant_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNewTestimonialId() {
		// TODO Auto-generated method stub
		try {
			return testRepo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public void save(Testimonial temp) {
		// TODO Auto-generated method stub
		
		testRepo.save(temp);
	}
	
	
}
