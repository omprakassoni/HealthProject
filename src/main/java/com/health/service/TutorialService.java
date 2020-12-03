package com.health.service;

import java.util.List;

import com.health.model.Category;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.Language;
import com.health.model.Topic;

public interface TutorialService {


	List<Tutorial> findAll();

	Boolean upadatePreStatus(int scriptStautusByQuality, Topic topic, Category category, Language language);

	Boolean updatePre(String preUpload, int preUploadStatus, Language lan, Topic topic, Category category);


	Boolean updateKeyword(String keywordMessage, int status,User user, Topic topic ,Category category);

	Boolean updateOutline(String outlineMessage, int status,User user,Topic topic,Category category);

	Boolean updateSlide(String slideUpload, int statusSlide,User user,Topic topic,Category category);

	Boolean updateGraphics(String graphicsUpload, int graphicsUploadStatus,User user,Topic topic,Category category);

	Boolean updateScript(String scriptUpload, int statusScript,User user,Topic topic,Category category);

	Boolean updateVideo(String videoUpload, int statusVideo,User user,Topic topic,Category category);

	Boolean updateVideoStatusByAdmin(int StatusByAdmin,Topic topic,Category category,Language language);

	// Domain Accept Or Need To Improvement

	Boolean updateOutlineStatusByDomain(int outlineStautusByDomain,Topic topic,Category category,Language language);

	Boolean updateScriptStatusByDomain(int scriptStautusByDomain,Topic topic,Category category,Language language);

	// Quality review Or need To Improvements

	Boolean updateOutLineStatusByQuality(int scriptStautusByQuality,Topic topic,Category category,Language language);

	Boolean upadateSlideStatusByQuality(int scriptStautusByQuality,Topic topic,Category category,Language language);

	Boolean upadateScriptStatusByQuality(int scriptStautusByQuality,Topic topic,Category category,Language language);

	Boolean upadateKeywordByQuality(int scriptStautusByQuality,Topic topic,Category category,Language language);

	Boolean upadateVideoByQuality(int videoStautusByQuality,Topic topic,Category category,Language language);

	// here is code for upadet Status when click as public

	Boolean updateStatusByQualityApprove(int StatusApprove,int IdByrecord);
	Boolean updateGraphicsStatusByDomain(int graphicsStatus, Topic topic, Category category, Language language);
	Boolean upadateGraphicsStatusImpByDomain(int scriptStautusByQuality,Topic topic,Category category,Language language);
	Boolean upadateGraphicsByQuality(int graphicsStautusByQuality,Topic topic,Category category,Language language);



}