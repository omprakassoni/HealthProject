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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="topicCat_id")
	private TopicCategoryMapping topicCatId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Training_id")
	private TrainingInformation traineeInfos;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Event_id")
	private Event event;

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


	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public TrainingTopic(int trainingTopicId, TopicCategoryMapping topicCatId, TrainingInformation traineeInfos, Event event) {
		super();
		this.trainingTopicId = trainingTopicId;
		this.topicCatId = topicCatId;
		this.traineeInfos = traineeInfos;
		this.event = event;
	}
	public TrainingTopic(int trainingTopicId, TopicCategoryMapping topicCatId, TrainingInformation traineeInfos) {
		super();
		this.trainingTopicId = trainingTopicId;
		this.topicCatId = topicCatId;
		this.traineeInfos = traineeInfos;

	}
	public TrainingTopic(int trainingTopicId, TopicCategoryMapping topicCatId, Event event) {
		super();
		this.trainingTopicId = trainingTopicId;
		this.topicCatId = topicCatId;
		this.event = event;
	}

	public TrainingTopic() {

	}
}
