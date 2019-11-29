package com.health.model;

import java.security.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.websocket.OnError;

@Entity
@Table(name="tutorial")
public class Tutorial{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tutorialid;
	private String topicname;
	public String getTopicname() {
		return topicname;
	}

	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Set<category_Tutorial> getCategoryTutorials() {
		return categoryTutorials;
	}

	public void setCategoryTutorials(Set<category_Tutorial> categoryTutorials) {
		this.categoryTutorials = categoryTutorials;
	}


	private String script;
	private String outlin;
	private String video;
	private String timeScript;
	private String keyword;
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	private Timestamp date;
	
	
	private String language;

	public int getTutorialid() {
		return tutorialid;
	}

	public void setTutorialid(int tutorialid) {
		this.tutorialid = tutorialid;
	}



	public String getScript() {
		return script;
	}



	public void setScript(String script) {
		this.script = script;
	}



	public String getOutlin() {
		return outlin;
	}



	public void setOutlin(String outlin) {
		this.outlin = outlin;
	}



	public String getVideo() {
		return video;
	}



	public void setVideo(String video) {
		this.video = video;
	}



	public String getSlide() {
		return timeScript;
	}



	public void setSlide(String slide) {
		this.timeScript = slide;
	}



	public String getTimeScript() {
		return timeScript;
	}

	public void setTimeScript(String timeScript) {
		this.timeScript = timeScript;
	}

	public Timestamp getDate() {
		return date;
	}



	public void setDate(Timestamp date) {
		this.date = date;
	}


	@OneToMany(mappedBy = "tutorial", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<category_Tutorial> categoryTutorials=new HashSet<>();

	
	
	
}
