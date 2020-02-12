package com.health.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Category;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.language;
import com.health.model.topic;
import com.health.repository.TutorialDao;
import com.health.service.tutorialService;

@Service
public class tutorialServiceImpl implements tutorialService {

	@Autowired
	private TutorialDao tutorialDao;
		
	@Override
	public List<Tutorial> findAll() {

		List<Tutorial> local = (List<Tutorial>) tutorialDao.findAll();

		return local;

	}

	@Transactional
	public Boolean updateKeyword(String keywordMessage,int status,User user,topic topic ,Category category) 
	{	
		
		int keywordfStatus=	tutorialDao.updateKeyword(keywordMessage,status,user,topic,category);
		
		if(keywordfStatus>0) 
		{
			return true;
			
		}else {
			return false;
		}
	}
	
	
	
	@Transactional
	public Boolean updateOutline(String outlineMessage, int status, User user, topic topic, Category category) {
		
		int outlineStatus=tutorialDao.updateOutline(outlineMessage,status,user,topic,category);
		
		if(outlineStatus>0) 
		{
			return true;
			
		}else {
			return false;
		}
	}

	@Transactional
	public Boolean updateSlide(String slideUpload, int statusSlide, User user, topic topic, Category category) 
	{
		
		int slideStatus=tutorialDao.updateSlide(slideUpload,statusSlide,user,topic,category);
			
		if(slideStatus>0) 
		{
			return true;
			
		}else {
			return false;
		}

	
	}

	@Transactional
	public Boolean updateScript(String scriptUpload, int scriptStatus, User user, topic topic, Category category)
	{
		
		int scriptSta=tutorialDao.updateScript(scriptUpload,scriptStatus,user,topic,category);
		
		if(scriptSta>0) 
		{
			return true;
			
		}else
		{
			return false;
		}
		
		
		
		
	}

	@Transactional
	public Boolean updateVideo(String videoUpload, int statusVideo, User user, topic topic, Category category)
	{
		int v=tutorialDao.updateVideo(videoUpload, statusVideo, user, topic, category);
		
		if(v>0)
		{	
			return true;
		}
		else {
			return false;
		}
		
	}

	//admin update status =2
	
	@Transactional
	public Boolean updateVideoStatusByAdmin(int StatusByAdmin,topic topic,Category category,language language)
	{

		int statusByAdmin=tutorialDao.updateVideoStatusByAdmin( StatusByAdmin, topic, category, language);
		
		if(statusByAdmin>0)
		{
			
			return true;
		}else {
			
			return false;
		}
			
		
	
	}
	
	

}
