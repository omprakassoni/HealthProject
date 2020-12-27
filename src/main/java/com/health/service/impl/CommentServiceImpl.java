package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Comment;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.repository.CommentRepository;
import com.health.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepository comRepo;

	@Override
	public int getNewCommendId() {
		// TODO Auto-generated method stub
		try {
			return comRepo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public void save(Comment com) {
		// TODO Auto-generated method stub
		comRepo.save(com);
	}

	@Override
	public List<Comment> getCommentBasedOnUserTutorialType(String type, User usr, Tutorial tut) {
		// TODO Auto-generated method stub
		return comRepo.getCommentBasedOnUserTutorialType(type, usr, tut);
	}
}

