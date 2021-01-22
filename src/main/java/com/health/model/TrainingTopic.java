package com.health.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TrainingTopic {

	@Id
	private int trainingTopicId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="topicCat_id")
	private TopicCategoryMapping topicCatId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Training_id")
	private TrainingInformation traineeInfos;
	
	public int getTrainingTopicId() {
		return trainingTopicId;
	}

	public void setTrainingTopicId(int trainingTopicId) {
		this.trainingTopicId = trainingTopicId;
	}

	public TopicCategoryMapping getTopicCatId() {
		return topicCatId;
	}

	public void setTopicCatId(TopicCategoryMapping topicCatId) {
		this.topicCatId = topicCatId;
	}

	public TrainingInformation getTraineeInfos() {
		return traineeInfos;
	}

	public void setTraineeInfos(TrainingInformation traineeInfos) {
		this.traineeInfos = traineeInfos;
	}

	public TrainingTopic(int trainingTopicId, TopicCategoryMapping topicCatId, TrainingInformation traineeInfos) {
		super();
		this.trainingTopicId = trainingTopicId;
		this.topicCatId = topicCatId;
		this.traineeInfos = traineeInfos;
	}
	
	public TrainingTopic() {
		
	}
}
