package com.health.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Brouchure {

	@Id
	private int id;
	
	private String posterPath;
	
	private boolean showOnHomepage=false;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "lan_id")
	private Language lan;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "topicCat_id")
	private TopicCategoryMapping topicCatId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public Language getLan() {
		return lan;
	}

	public void setLan(Language lan) {
		this.lan = lan;
	}

	public TopicCategoryMapping getTopicCatId() {
		return topicCatId;
	}

	public void setTopicCatId(TopicCategoryMapping topicCatId) {
		this.topicCatId = topicCatId;
	}

	public boolean isShowOnHomepage() {
		return showOnHomepage;
	}

	public void setShowOnHomepage(boolean showOnHomepage) {
		this.showOnHomepage = showOnHomepage;
	}
	
	
	
}
