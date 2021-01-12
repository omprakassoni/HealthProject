package com.health.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.ContributorAssignedTutorial;
import com.health.model.Tutorial;
import com.health.repository.TutorialRepository;
import com.health.service.TutorialService;


@Service
public class TutorialServiceImpl implements TutorialService {

	@Autowired
	private TutorialRepository tutorialRepo;

	@Override
	public List<Tutorial> findAll() {
		// TODO Auto-generated method stub
		return (List<Tutorial>) tutorialRepo.findAll();
	}

	@Override
	public int getNewId() {
		// TODO Auto-generated method stub
		try {
			return tutorialRepo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public List<Tutorial> findAllByContributorAssignedTutorial(ContributorAssignedTutorial con) {
		// TODO Auto-generated method stub
		return tutorialRepo.findAllByconAssignedTutorial(con);
	}

	@Override
	public void save(Tutorial tut) {
		// TODO Auto-generated method stub
		tutorialRepo.save(tut);
	}

	@Override
	public Tutorial getById(int id) {
		// TODO Auto-generated method stub
		Optional<Tutorial> local=tutorialRepo.findById(id);
		return local.get();
	}

	@Override
	public List<Tutorial> findAllByContributorAssignedTutorialList(List<ContributorAssignedTutorial> con) {
		// TODO Auto-generated method stub
		List<Tutorial> localList=new ArrayList<Tutorial>();
		for(ContributorAssignedTutorial conTemp:con) {
			localList.addAll(tutorialRepo.findAllByconAssignedTutorial(conTemp));
		}
		return localList;

	}

	@Override
	public List<Tutorial> findAllBystatus(boolean status) {
		// TODO Auto-generated method stub
		return tutorialRepo.findAllBystatus(status);
	}




}