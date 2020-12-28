package com.health.model;

import java.sql.Timestamp;
import java.util.HashSet;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
	
	@Column(name = "graphics",length = 1000)
	private String graphics;
	
	@Column(name = "graphics_status")
	private int graphicsStatus = 0;
	
	@Column(name = "keyword",length = 1000)
	private String keyword;
	
	@Column(name = "keyword_status")
	private int keywordStatus = 0;
	
	@Column(name = "outline",length = 1000)
	private String outline;
	
	@Column(name = "outline_status")
	private int outlineStatus = 0;
	
	@Column(name = "preRequistic")
	private String preRequistic;
	
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

	public String getGraphics() {
		return graphics;
	}

	public void setGraphics(String graphics) {
		this.graphics = graphics;
	}

	public int getGraphicsStatus() {
		return graphicsStatus;
	}

	public void setGraphicsStatus(int graphicsStatus) {
		this.graphicsStatus = graphicsStatus;
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

	public String getPreRequistic() {
		return preRequistic;
	}

	public void setPreRequistic(String preRequistic) {
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

//@Entity
//@Table(name="tutorial_resoureses")
//public class Tutorial
//{
//
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="id", nullable = false, updatable = false)
//	private int tutorialid;
//
//	private String topicname;
//
//	public String getTopicname()
//	{
//		return topicname;
//	}
//
//	public void setTopicname(String topicname) {
//		this.topicname = topicname;
//	}
//	public String getLanguage() {
//		return language;
//	}
//
//	public void setLanguage(String language) {
//		this.language = language;
//	}
//
//	private String script;
//	private int scriptStatus;
//
//	@Column(length = 1000)
//	private String outlin;
//	private int outlineStatus;
//	private int outline_status_id;
//
//
//
//	/*
//	 * @ManyToOne(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
//	 *
//	 * @JoinColumn(name="outline_user_id")
//	 */
//
//
//	private String slide;
//	private int slideStatus;
//	private int slide_user_id;
//
//	public String getSlide() {
//		return slide;
//	}
//
//	public void setSlide(String slide) {
//		this.slide = slide;
//	}
//
//	public int getSlideStatus() {
//		return slideStatus;
//	}
//
//	public void setSlideStatus(int slideStatus) {
//		this.slideStatus = slideStatus;
//	}
//
//	public int getSlide_user_id() {
//		return slide_user_id;
//	}
//
//	public void setSlide_user_id(int slide_user_id) {
//		this.slide_user_id = slide_user_id;
//	}
//
//	private String video;
//	private int videoStatus;
//
//
//	private String timeScript;
//	private String prerequisite;
//	@Column(name="prerequisiteStatus")
//	private int prerequisiteStatus;
//
//
//	public String getPrerequisite() {
//		return prerequisite;
//	}
//
//	public void setPrerequisite(String prerequisite) {
//		this.prerequisite = prerequisite;
//	}
//
//	public int getPrerequisiteStatus() {
//		return prerequisiteStatus;
//	}
//
//	public void setPrerequisiteStatus(int prerequisiteStatus) {
//		this.prerequisiteStatus = prerequisiteStatus;
//	}
//
//	public void setDate(String date) {
//		Date = date;
//	}
//
//	private String keyword;
//	private int keywordStatusSet;
//	private long keyword_user_id;
//
//
//	private String graphics;
//	private int graphicsStatus;
//	private long graphicsUserid;
//
//	public int getOutline_status_id() {
//		return outline_status_id;
//	}
//
//	public void setOutline_status_id(int outline_status_id) {
//		this.outline_status_id = outline_status_id;
//	}
//
//	public String getGraphics() {
//		return graphics;
//	}
//
//	public void setGraphics(String graphics) {
//		this.graphics = graphics;
//	}
//
//	public int getGraphicsStatus() {
//		return graphicsStatus;
//	}
//
//	public void setGraphicsStatus(int graphicsStatus) {
//		this.graphicsStatus = graphicsStatus;
//	}
//
//	public long getGraphicsUserid() {
//		return graphicsUserid;
//	}
//
//	public void setGraphicsUserid(long graphicsUserid) {
//		this.graphicsUserid = graphicsUserid;
//	}
//
//	public Tutorial(){
//		super();
//	}
//
//	public Tutorial(String keyword,int keywordStatusSet,long keyword_user_id){
//		super();
//		this.keyword = keyword;
//		this.keywordStatusSet = keywordStatusSet;
//		this.keyword_user_id = keyword_user_id;
//
//
//	}
//
//	public long getKeyword_user_id() {
//		return keyword_user_id;
//	}
//
//	public void setKeyword_user_id(long keyword_user_id) {
//		this.keyword_user_id = keyword_user_id;
//	}
//
//	public int getKeywordStatusSet(){
//		return keywordStatusSet;
//	}
//
//	public int getOutlineStatus() {
//		return outlineStatus;
//	}
//
//	public void setOutlineStatus(int outlineStatus) {
//		this.outlineStatus = outlineStatus;
//	}
//
//	public void setKeywordStatusSet(int keywordStatusSet) {
//		this.keywordStatusSet = keywordStatusSet;
//	}
//	public java.sql.Timestamp getDateInfo()
//	{
//		return dateInfo;
//	}
//
//	public void setDateInfo(java.sql.Timestamp timestamp) {
//		this.dateInfo = timestamp;
//	}
//
//	private String Date;
//	private java.sql.Timestamp dateInfo;
//
//	public int getScriptStatus() {
//		return scriptStatus;
//	}
//
//	public void setScriptStatus(int scriptStatus) {
//		this.scriptStatus = scriptStatus;
//	}
//
//	public int getVideoStatus() {
//		return videoStatus;
//	}
//
//	public void setVideoStatus(int videoStatus) {
//		this.videoStatus = videoStatus;
//	}
//
//
//
//	private int status;
//	public int getStatus() {
//		return status;
//	}
//
//	public void setStatus(int status) {
//		this.status = status;
//	}
//
//
//
//	public String getKeyword() {
//		return keyword;
//	}
//
//	public void setKeyword(String keyword) {
//		this.keyword = keyword;
//	}
//
//	private String language;
//
//	public int getTutorialid() {
//		return tutorialid;
//	}
//
//	public void setTutorialid(int tutorialid) {
//		this.tutorialid = tutorialid;
//	}
//
//	public String getScript() {
//
//
//		return script;
//	}
//
//	public void setScript(String script) {
//		this.script = script;
//	}	/* System.err.println("Hi Topic"+inputTopic); */
//
//	public String getOutlin() {
//		return outlin;
//	}
//
//	public void setOutlin(String outlin) {
//		this.outlin = outlin;
//	}
//
//	public String getVideo() {
//		return video;
//	}
//
//
//
//	public void setVideo(String video) {
//		this.video = video;
//	}
//
//
//	public String getTimeScript() {
//		return timeScript;
//	}
//
//	public void setTimeScript(String timeScript) {
//		this.timeScript = timeScript;
//
//	}
//	 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	 @JoinColumn(name="category_id")
//	 private Category category;
//
//
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name="langaueg_id")
//	 private language lan;
//
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name="topic_id")
//	private topic topic;
//
//
//	@ManyToOne(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
//	@JoinColumn(name="user_id")
//	private  User user;
//
//
//	@OneToMany(mappedBy = "tutorial", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JsonIgnore
//	private Set<commentOnComponent> commentOnComponent = new HashSet<>();
//
//
//
//
//		public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//		public Category getCategory() {
//			return category;
//		}
//
//		public void setCategory(Category category) {
//			this.category = category;
//		}
//
//		public language getLan() {
//			return lan;
//		}
//
//		public void setLan(language lan) {
//			this.lan = lan;
//		}
//
//		public topic getTopic() {
//			return topic;
//		}
//
//		public void setTopic(topic topic) {
//			this.topic = topic;
//		}
//
//		public String getDate() {
//			return Date;
//		}
//
//}