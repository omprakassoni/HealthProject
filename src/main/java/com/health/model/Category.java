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

import com.health.domain.security.UserRole;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@Column(name = "category_id", nullable = false, updatable = false)
	private int categoryId;
	
	@Column(name = "category_name", nullable = false)
	private String catName;
	
	@Column(name = "date_added", nullable = false)
	private Timestamp dateAdded;
	
	@Column(name = "status", nullable = false)
	private boolean status;
	
	@Column(name = "Image_path", nullable = false)
	private String posterPath;
	
	@Column(name = "Description", nullable = false)
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "cat", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<TopicCategoryMapping> topicCategoryMap=new HashSet<TopicCategoryMapping>();
	
	@OneToMany(mappedBy = "cat", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<UserRole> userRoles=new HashSet<UserRole>();
	
	@OneToMany(mappedBy = "cat", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Question> questions=new HashSet<Question>();

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
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

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<TopicCategoryMapping> getTopicCategoryMap() {
		return topicCategoryMap;
	}

	public void setTopicCategoryMap(Set<TopicCategoryMapping> topicCategoryMap) {
		this.topicCategoryMap = topicCategoryMap;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}


//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@JoinColumn(name="id")
//	@Column(name="id", nullable = false, updatable = false)
//	private int id;
//	private String categoryname;
//	private int status;
//	private Timestamp created;
//	private String uploadCategoryImage;
//	private String categoryDesc;
//
//	public Timestamp getCreated() {
//		return created;
//	}
//
//	public void setCreated(Timestamp created) {
//		this.created = created;
//	}
//
//	public int getStatus() {
//		return status;
//	}
//
//	public void setStatus(int status) {
//		this.status = status;
//	}
//
//
//	public Long getUserid() {
//		return userid;
//	}
//
//	public void setUserid(Long userid) {
//		this.userid = userid;
//	}
//
//
//
//	public String getUploadCategoryImage() {
//		return uploadCategoryImage;
//	}
//
//	public void setUploadCategoryImage(String uploadCategoryImage) {
//		this.uploadCategoryImage = uploadCategoryImage;
//	}
//
//
//	public String getCategoryDesc() {
//		return categoryDesc;
//	}
//
//	public void setCategoryDesc(String categoryDesc) {
//		this.categoryDesc = categoryDesc;
//	}
//
//
//
//
//	private Long userid;
//
//	  @OneToMany(mappedBy = "category",cascade =CascadeType.ALL) private
//	  List<Tutorial> tutorials;
//
//	  @OneToMany(mappedBy = "category",cascade =CascadeType.ALL) private
//	  List<contributor_Role> contributor_Roles;
//
//	  @OneToMany(mappedBy = "category",cascade =CascadeType.ALL)
//	  private List<topic>  topic;
//
//	  @OneToMany(mappedBy = "category",cascade =CascadeType.ALL)
//	  private List<commentOnComponent>  commentOnComponent;
//
//
//
//	  @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
//		 private List<TraningInformation> traningInformations;
//
//
//		public List<topic> getTopic() {
//			return topic;
//		}
//
//		public void setTopic(List<topic> topic) {
//			this.topic = topic;
//		}
//
//	public List<Tutorial> getTutorials() {
//		return tutorials;
//	}
//
//	public void setTutorials(List<Tutorial> tutorials) {
//		this.tutorials = tutorials;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getCategoryname() {
//		return categoryname;
//	}
//
//	public void setCategoryname(String categoryname) {
//		this.categoryname = categoryname;
//	}

}
