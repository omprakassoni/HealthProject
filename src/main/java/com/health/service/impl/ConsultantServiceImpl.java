package com.health.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.health.model.Consultant;
import com.health.model.User;
import com.health.repository.ConsultantRepository;

import com.health.service.ConsultantService;


@Service
public class ConsultantServiceImpl implements ConsultantService {

	@Autowired
	private ConsultantRepository consultantRepo;

	@Override
	public List<Consultant> findAll() {

		List<Consultant> local = (List<Consultant>) consultantRepo.findAll();

		return local;

	}
	
	@Override
	public void deleteProduct(Integer id){

		consultantRepo.deleteById(id);
																																																																												
	}

	@Override
	@Transactional
	public Boolean UpdateConsalantant(String description,String name, String uploadVideo,int id) {
		
//		int status=	consultantRepo.updateconsalantant( description,name,uploadVideo,id);
//		
//		System.err.println(status);
//		
//		if(status>0) {
//			return true;
//		}else {
//			return false;
//		}
	
		return true;
	}
	
	
	@Override
	public Consultant findById(int id) {
		// TODO Auto-generated method stub
		Optional<Consultant> local=consultantRepo.findById(id);
		return local.get();
	}

	@Override
	public void save(Consultant consult) {
		// TODO Auto-generated method stub
		
		consultantRepo.save(consult);
	}

	@Override
	public int getNewConsultantId() {
		// TODO Auto-generated method stub
		try {
			return consultantRepo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public Consultant findByUser(User usr) {
		// TODO Auto-generated method stub
		return consultantRepo.findByuser(usr);
	}

	
	
	
}
 

	
	

