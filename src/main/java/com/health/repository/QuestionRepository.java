package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Category;
import com.health.model.Language;
import com.health.model.Question;
import com.health.model.Topic;
import com.health.model.TopicCategoryMapping;
import com.health.model.Tutorial;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
	
//	
//	  @Query("from Question u where u.topic=?1")
//	  List<Question> findByTutorial(Topic topic);
//	  
//	  
//	  @Query("from Question u where u.topic=?1 and u.category=?2 and u.lan=?3")
//	  List<Question> findByQuestion(Topic topic,Category category,Language language);
	  
     @Query("select max(questionId) from Question")
	 int getNewId();
	
	 @Query("from Question where topicCatId = ?1 and lan = ?2")
	 Question findByTopicLan(TopicCategoryMapping topicCat, Language lan);
	 
	

}
