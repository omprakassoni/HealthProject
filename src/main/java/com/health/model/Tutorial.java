package com.health.model;

import java.sql.Timestamp;
import java.util.HashSet;
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
@Table(name = "tutorial_resource")
public class Tutorial {

	@Id
	@Column(name = "tutorial_id",updatable = false,nullable = false)
	private int tutorialId;

	@Column(name = "script",length = 1000)
	private String script;

	@Column(name = "script_status")
	private int scriptStatus = 0;

	@Column(name = "slide",length = 1000)
	private String slide;

	@Column(name = "slide_status")
	private int slideStatus = 0;

	@Column(name = "keyword",length = 1000)
	private String keyword;

	@Column(name = "keyword_status")
	private int keywordStatus = 0;

	@Column(name = "outline",length = 1000)
	private String outline;

	@Column(name = "outline_status")
	private int outlineStatus = 0;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "preRequistics")
	private Tutorial preRequistic;

	@Column(name = "preRequistic_status")
	private int preRequisticStatus = 0;

	@Column(name = "date_added", nullable = false)
	private Timestamp dateAdded;

	@Column(name = "enabled")
	private boolean status;

	@Column(name = "timescript",length = 1000)
	private String timeScript;

	@Column(name = "topicName",length = 1000)
	private String topicName;

	@Column(name = "video",length = 1000)
	private String video;

	@Column(name = "video_status")
	private int videoStatus = 0;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "conAssignedTutorial")
	private ContributorAssignedTutorial conAssignedTutorial;

	@OneToMany(mappedBy = "tutorialInfos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Comment> comments =new HashSet<Comment>();

	@OneToMany(mappedBy = "preRequistic", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Tutorial> preRequisticTutorial =new HashSet<Tutorial>();

	@OneToMany(mappedBy = "tutorialInfos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<LogManegement> logs =new HashSet<LogManegement>();

	public int getTutorialId() {
		return tutorialId;
	}

	public void setTutorialId(int tutorialId) {
		this.tutorialId = tutorialId;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public int getScriptStatus() {
		return scriptStatus;
	}

	public void setScriptStatus(int scriptStatus) {
		this.scriptStatus = scriptStatus;
	}

	public String getSlide() {
		return slide;
	}

	public void setSlide(String slide) {
		this.slide = slide;
	}

	public int getSlideStatus() {
		return slideStatus;
	}

	public void setSlideStatus(int slideStatus) {
		this.slideStatus = slideStatus;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getKeywordStatus() {
		return keywordStatus;
	}

	public void setKeywordStatus(int keywordStatus) {
		this.keywordStatus = keywordStatus;
	}

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

	public int getOutlineStatus() {
		return outlineStatus;
	}

	public void setOutlineStatus(int outlineStatus) {
		this.outlineStatus = outlineStatus;
	}

	public  Tutorial getPreRequistic() {
		return preRequistic;
	}

	public void setPreRequistic(Tutorial preRequistic) {
		this.preRequistic = preRequistic;
	}

	public int getPreRequisticStatus() {
		return preRequisticStatus;
	}

	public void setPreRequisticStatus(int preRequisticStatus) {
		this.preRequisticStatus = preRequisticStatus;
	}

	public Timestamp getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Timestamp dateAdded) {
		this.dateAdded = dateAdded;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getTimeScript() {
		return timeScript;
	}

	public void setTimeScript(String timeScript) {
		this.timeScript = timeScript;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public int getVideoStatus() {
		return videoStatus;
	}

	public void setVideoStatus(int videoStatus) {
		this.videoStatus = videoStatus;
	}

	public ContributorAssignedTutorial getConAssignedTutorial() {
		return conAssignedTutorial;
	}

	public void setConAssignedTutorial(ContributorAssignedTutorial conAssignedTutorial) {
		this.conAssignedTutorial = conAssignedTutorial;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<LogManegement> getLogs() {
		return logs;
	}

	public void setLogs(Set<LogManegement> logs) {
		this.logs = logs;
	}


}
