package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Carousel;
import com.health.repository.CarouselRepository;
import com.health.service.CarouselService;

@Service
public class CarouselServiceImpl implements CarouselService{

	@Autowired
	private CarouselRepository repo;

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
	public void save(Carousel temp) {
		// TODO Auto-generated method stub
		repo.save(temp);
	}

	@Override
	public List<Carousel> findAll() {
		// TODO Auto-generated method stub
		return (List<Carousel>) repo.findAll();
	}

	@Override
	public List<Carousel> findByOnHome(boolean value) {
		// TODO Auto-generated method stub
		return repo.findAllByshowOnHomepage(value);
	}

	@Override
	public void delete(Carousel temp) {
		// TODO Auto-generated method stub
		repo.delete(temp);
	}

}
