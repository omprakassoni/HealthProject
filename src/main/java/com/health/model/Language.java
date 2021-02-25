
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

import com.health.domain.security.UserRole;


@Entity
public class Language {

	@Id
	@Column(name = "lan_id",updatable = false,nullable = false)
	private int lanId;

	@Column(nullable = false)
	private String langName;

	@Column(name = "date_added", nullable = false)
	private Timestamp dateAdded;

	@Column(name = "status", nullable = false)
	private boolean status=true;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "lan", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<UserRole> userRoles=new HashSet<UserRole>();

	@OneToMany(mappedBy = "lan", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Question> questions=new HashSet<Question>();

	@OneToMany(mappedBy = "lan", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ContributorAssignedTutorial> conAssignedTutorial=new HashSet<ContributorAssignedTutorial>();

	@OneToMany(mappedBy = "lan", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<TrainingInformation> trainingInfos=new HashSet<TrainingInformation>();

	@OneToMany(mappedBy = "lan", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Brouchure> brouchure=new HashSet<Brouchure>();

	@OneToMany(mappedBy = "lan", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Event> events=new HashSet<Event>();

	public int getLanId() {
		return lanId;
	}

	public void setLanId(int lanId) {
		this.lanId = lanId;
	}

	public String getLangName() {
		return langName;
	}

	public void setLangName(String langName) {
		this.langName = langName;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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


	public Set<ContributorAssignedTutorial> getConAssignedTutorial() {
		return conAssignedTutorial;
	}

	public void setConAssignedTutorial(Set<ContributorAssignedTutorial> conAssignedTutorial) {
		this.conAssignedTutorial = conAssignedTutorial;
	}

	public Set<TrainingInformation> getTrainingInfos() {
		return trainingInfos;
	}

	public void setTrainingInfos(Set<TrainingInformation> trainingInfos) {
		this.trainingInfos = trainingInfos;
	}




//  @Id
//  @GeneratedValue(strategy=GenerationType.AUTO)
//  @Column(name="id", nullable = false, updatable = false)
//
//  	private int id;
//	private  String languageName ;
//
//	private Timestamp timedate;
//
//
//
//	  public Timestamp getTimedate() {
//		return timedate;
//	}
//
//	public void setTimedate(Timestamp timedate) {
//		this.timedate = timedate;
//	}
//
//	private String createdBy;
//
//	  public String getCreatedBy() {
//		  return createdBy;
//	  }
//
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//
//	/*
//	 * @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	 *
//	 * @JoinColumn(name="user_id") private User user;
//	 */
//
//	@OneToMany(mappedBy = "lan",cascade =CascadeType.ALL)
//	private List<Tutorial> tutorials;
//
//	@OneToMany(mappedBy = "lan", cascade = CascadeType.ALL)
//	private List<contributor_Role> contributor_Roles;
//
//	@OneToMany(mappedBy = "language", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	private Set<UserRole> userRoles = new HashSet<>();
//
//
//	@OneToMany(mappedBy = "lan", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	private Set<language_assign> languages= new HashSet<>();
//
//	@OneToMany(mappedBy = "language", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	private Set<commentOnComponent>  commentOnComponent= new HashSet<>();
//
//
//	public Set<UserRole> getUserRoles() {
//
//		return userRoles;
//	}
//
//	public List<contributor_Role> getContributor_Roles() {
//		return contributor_Roles;
//	}
//
//	public void setContributor_Roles(List<contributor_Role> contributor_Roles) {
//		this.contributor_Roles = contributor_Roles;
//	}
//
//	public void setUserRoles(Set<UserRole> userRoles) {
//		this.userRoles = userRoles;
//	}
//
//	public List<Tutorial> getTutorials() {
//		return tutorials;
//	}
//
//	public Set<language_assign> getLanguages() {
//		return languages;
//	}
//
//	public void setLanguages(Set<language_assign> languages) {
//		this.languages = languages;
//	}
//
//	public void setTutorials(List<Tutorial> tutorials) {
//		this.tutorials = tutorials;
//	}
//
//
//		public int getId() {
//		  return id; }
//
//	  public void setId(int id) {
//		  this.id = id; }
//
//
//	  public String getLanguageName() {
//		  return languageName; }
//
//
//
//	  public void setLanguageName(String languageName)
//	  { this.languageName =
//	  languageName; }
//


  }
