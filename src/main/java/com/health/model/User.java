package com.health.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
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
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.health.domain.security.Authority;
import com.health.domain.security.UserRole;

@Entity
public class User implements UserDetails{

	@Id
	@Column(name="id", nullable = false, updatable = false)
	private Long id;
	
	private String username;
	
	private Date dob;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	@Column(name = "token")
	private String token;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "master_trainer_organization")
	private String organization ;
	
	@Column(name = "master_trainer_experience")
	private int experience;
	
	@Column(name = "master_trainer_aadhar")
	private long aadharNumber;


	@Column(name="email", nullable = false, updatable = false)
	private String email;
	
	private long phone;
	
	private boolean registered=true;
	
	@Column(name = "dateAdded",nullable = false,updatable = false)
	private Timestamp dateAdded;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<UserRole>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Category> categories = new HashSet<Category>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Topic> topics = new HashSet<Topic>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Language> languages = new HashSet<Language>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Question> questions = new HashSet<Question>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Event> events = new HashSet<Event>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Testimonial> testi = new HashSet<Testimonial>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Consultant> consults = new HashSet<Consultant>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ContributorAssignedTutorial> conAssignedTutorial=new HashSet<ContributorAssignedTutorial>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<TrainingInformation> trainingInfo =new HashSet<TrainingInformation>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Comment> comments =new HashSet<Comment>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<LogManegement> logs =new HashSet<LogManegement>();


//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JsonIgnore
//	private Set<commentOnComponent> commentOnComponent = new HashSet<>();



//	@OneToMany(mappedBy ="user",cascade =
//	{CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH })
//	 List<Topic> topics;

//	 @OneToMany(mappedBy = "user",cascade =
//	{CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH })
//	 List<language_assign> languageassigns;
//
//
//
//	@OneToMany(mappedBy ="user",cascade =
//	{CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH })
//	 List<contributor_Role> contributor_Roles;
//
//
//	@OneToMany(mappedBy ="user",cascade =
//	{CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH })
//	List<Tutorial> tutorial;


	/*
	 * @OneToMany(mappedBy ="user",cascade =
	 * {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH
	 * }) List<language> language;
	 */


	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	@Override
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorites = new HashSet<>();

		for(UserRole x:userRoles)
		{
			if(x.getStatus()) {
				authorites.add(new Authority(x.getRole().getName()));
			}
		}

		return authorites;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		return registered;
	}

	public String getFullName() {
		return  firstName + ' ' + lastName;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isRegistered() {
		return registered;
	}
	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public Timestamp getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Timestamp dateAdded) {
		this.dateAdded = dateAdded;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	public Set<Topic> getTopics() {
		return topics;
	}
	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}
	public Set<Language> getLanguages() {
		return languages;
	}
	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}
	public Set<Event> getEvents() {
		return events;
	}
	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	public Set<Testimonial> getTesti() {
		return testi;
	}
	public void setTesti(Set<Testimonial> testi) {
		this.testi = testi;
	}
	public Set<Consultant> getConsults() {
		return consults;
	}
	public void setConsults(Set<Consultant> consults) {
		this.consults = consults;
	}
	public Set<ContributorAssignedTutorial> getConAssignedTutorial() {
		return conAssignedTutorial;
	}
	public void setConAssignedTutorial(Set<ContributorAssignedTutorial> conAssignedTutorial) {
		this.conAssignedTutorial = conAssignedTutorial;
	}
	public Set<TrainingInformation> getTrainingInfo() {
		return trainingInfo;
	}
	public void setTrainingInfo(Set<TrainingInformation> trainingInfo) {
		this.trainingInfo = trainingInfo;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

	
	

}
