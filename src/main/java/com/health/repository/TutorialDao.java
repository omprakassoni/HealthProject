package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.contributor_Role;
import com.health.model.language;
import com.health.model.topic;

public interface TutorialDao extends CrudRepository<Tutorial, Integer>{

	 Tutorial findBylanguage(String name);
	 
	/* Admin Reviwer */
	
	 
	
	/*
	 * @Query("from Tutorial u where u.videoStatus=1") List<Tutorial>
	 * findByOutlineScriptVideo(outlineStatus,);
	 */

	 

	@Query("from Tutorial u where u.videoStatus=1")
	List<Tutorial> finByVideoStatus(); 
	
	 
	@Query("from Tutorial u where u.user=?1 and topic=?2 and category=?3 and langaueg_id=?4")
	Tutorial finByKeywordContent(User user,topic topic,Category category,language language);
	
	@Query("from Tutorial u where  topic=?1 and category=?2 and langaueg_id=?3")
	Tutorial finByKeywordContentDomain(topic topic,Category category,language language);
	
	@Query("from Tutorial u where u.category=?1 and langaueg_id=?2")
	List<Tutorial> findByCategoryAndlanguage(Category category,language language);

	@Query("from Tutorial  u where u.user=?1 and u.category=?2")
	List<Tutorial> findByContributorTopic(User user,Category category);
	
	@Query("from Tutorial  u where u.user=?1 and u.topic=?2")
	List<Tutorial> findByTopicByLanguage(User user,topic topic);
		
	@Query("from Tutorial u where u.user=?1 and topic=?2")
	Tutorial findByContributorUserAndTopic(User user,topic topic);
		
	@Modifying
	@Query("update Tutorial set keyword=?1, keywordStatusSet=?2 where user_id=?3 and topic_id=?4 and category_id=?5")
	int updateKeyword(String keywordmeassage,int keywordstatus,User user,topic topic,Category category);
	
	@Modifying
	@Query("update Tutorial set outlin=?1, outlineStatus=?2 where user_id=?3 and topic_id=?4 and category_id=?5")
	int updateOutline(String outlinemeassage,int outlineStatus,User user,topic topic,Category category);
	
	@Modifying
	@Query("update Tutorial set slide=?1, slideStatus=?2 where user_id=?3 and topic_id=?4 and category_id=?5")
	int updateSlide(String outlinemeassage,int outlineStatus,User user,topic topic,Category category);
	
	@Modifying
	@Query("update Tutorial set script=?1,scriptStatus=?2 where user_id=?3 and topic_id=?4 and category_id=?5")
	int updateScript(String script,int scriptStatus,User user,topic topic,Category category);
	
	@Query("from Tutorial  u where u.user=?1")
	List<Tutorial> findByContributorRole(User role);
	
	@Modifying
	@Query("update Tutorial set video=?1, videoStatus=?2 where user_id=?3 and topic_id=?4 and category_id=?5")
	int updateVideo(String video,int videoStatus,User user,topic topic,Category category);
	
	//Admin Update status Video
	
	@Modifying
	@Query("update Tutorial set videoStatus=?1 where  topic_id=?2 and category_id=?3 and langaueg_id=?4")
	int updateVideoStatusByAdmin(int videoStatus,topic topic,Category category, language language);
	
	
 }
