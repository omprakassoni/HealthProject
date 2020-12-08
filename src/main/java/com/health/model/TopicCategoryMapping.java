package com.health.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "topic_category")
public class TopicCategoryMapping {

	@Id
	@Column(name = "topic_category_id",nullable = false,updatable = false)
	private int topicCategoryId;
	
	@Column(name = "status", nullable = false)
	private boolean status=true;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category cat;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "topic_id")
	private Topic topic;
	
	@OneToMany(mappedBy = "topicCatId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Question> questions=new HashSet<Question>();
	
	@OneToMany(mappedBy = "topicCatId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ContributorAssignedTutorial> conAssignedTutorial=new HashSet<ContributorAssignedTutorial>();

	public int getTopicCategoryId() {
		return topicCategoryId;
	}

	public void setTopicCategoryId(int topicCategoryId) {
		this.topicCategoryId = topicCategoryId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public TopicCategoryMapping() {
		
	}
	
	public TopicCategoryMapping(int topicCategoryId, boolean status, Category cat, Topic topic) {
		super();
		this.topicCategoryId = topicCategoryId;
		this.status = status;
		this.cat = cat;
		this.topic = topic;
	}


	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public Set<ContributorAssignedTutorial> getConAssignedTutorial() {
		return conAssignedTutorial;
	}

	public void setConAssignedTutorial(Set<ContributorAssignedTutorial> conAssignedTutorial) {
		this.conAssignedTutorial = conAssignedTutorial;
	}


	
	
	
	
}
