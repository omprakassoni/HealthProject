package com.health.service;

import com.health.model.PostQuestionaire;

public interface PostQuestionaireService {

	int getNewCatId();
	
	void save(PostQuestionaire temp);
}
