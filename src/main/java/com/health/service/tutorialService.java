package com.health.service;

import java.util.List;

import com.health.model.Category;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.language;
import com.health.model.topic;

public interface tutorialService {
	
	
	List<Tutorial> findAll();
	
	Boolean updateKeyword(String keywordMessage, int status,User user, topic topic ,Category category);

	Boolean updateOutline(String outlineMessage, int status,User user,topic topic,Category category);
	
	Boolean updateSlide(String slideUpload, int statusSlide,User user,topic topic,Category category);

	Boolean updateScript(String scriptUpload, int statusScript,User user,topic topic,Category category);

	Boolean updateVideo(String videoUpload, int statusVideo,User user,topic topic,Category category);
	
	Boolean updateVideoStatusByAdmin(int StatusByAdmin,topic topic,Category category,language language);
	
	

}
