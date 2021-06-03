package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.ContributorAssignedMultiUserTutorial;
import com.health.model.User;
import com.health.repository.ContributorAssignedMultiUserTutorialRepository;
import com.health.service.ContributorAssignedMultiUserTutorialService;

@Service
public class ContributorAssignedMultiUserTutorialServiceImpl implements ContributorAssignedMultiUserTutorialService {

	@Autowired
	private ContributorAssignedMultiUserTutorialRepository conRepo;

	@Override
	public void save(ContributorAssignedMultiUserTutorial con) {
		// TODO Auto-generated method stub
		conRepo.save(con);
	}

	@Override
	public int getNewId() {
		// TODO Auto-generated method stub
		try {
			return conRepo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public List<ContributorAssignedMultiUserTutorial> getAllByuser(User usr) {
		// TODO Auto-generated method stub
		return conRepo.findAllByuser(usr);
	}
	
	
}
