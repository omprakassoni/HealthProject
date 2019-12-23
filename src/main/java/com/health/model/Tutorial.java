package com.health.model;

import java.security.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.websocket.OnError;


@Entity
@Table(name="tutorial_resoureses")
public class Tutorial
{

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable = false, updatable = false)
	private int tutorialid;
	
	private String topicname;
	
	
	
	public String getTopicname() 
	{
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

	private String script;
	private String scriptStatus;
	
	private String outlin;
	private String outlineScript;
	
	private String video;
	private String videoStatus;
	
	private String timeScript;
	
	private String prerequisite;
	

	public String getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}

	public void setDate(String date) {
		Date = date;
	}

	private String keyword;
	private String keywordStatus;
	
	private String Date;
	
	public String getScriptStatus() {
		return scriptStatus;
	}

	public void setScriptStatus(String scriptStatus) {
		this.scriptStatus = scriptStatus;
	}

	public String getOutlineScript() {
		return outlineScript;
	}

	public void setOutlineScript(String outlineScript) {
		this.outlineScript = outlineScript;
	}

	public String getVideoStatus() {
		return videoStatus;
	}

	public void setVideoStatus(String videoStatus) {
		this.videoStatus = videoStatus;
	}

	public String getKeywordStatus() {
		return keywordStatus;
	}

	public void setKeywordStatus(String keywordStatus) {
		this.keywordStatus = keywordStatus;
	}

	private int status;
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}



	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

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
	}	/* System.err.println("Hi Topic"+inputTopic); */
	



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
	 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinColumn(name="category_id")
	 private Category category;
	
	 
	 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="langaueg_id")
	 private language lan;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="topic_id")
	private topic topic;



		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public language getLan() {
			return lan;
		}

		public void setLan(language lan) {
			this.lan = lan;
		}

		public topic getTopic() {
			return topic;
		}

		public void setTopic(topic topic) {
			this.topic = topic;
		}

		public String getDate() {
			return Date;
		}
		
	
	
}
