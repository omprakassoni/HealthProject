package com.health.model;

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
	private Set<UserRole> userRoles = new HashSet<>();


	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<commentOnComponent> commentOnComponent = new HashSet<>();



	@OneToMany(mappedBy ="user",cascade =
	{CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH })
	 List<Topic> topics;

	 @OneToMany(mappedBy = "user",cascade =
	{CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH })
	 List<language_assign> languageassigns;



	@OneToMany(mappedBy ="user",cascade =
	{CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH })
	 List<contributor_Role> contributor_Roles;


	@OneToMany(mappedBy ="user",cascade =
	{CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH })
	List<Tutorial> tutorial;


	/*
	 * @OneToMany(mappedBy ="user",cascade =
	 * {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH
	 * }) List<language> language;
	 */

	public List<language_assign> getLanguageassigns() {
		return languageassigns;
	}
	public void setLanguageassigns(List<language_assign> languageassigns) {
		this.languageassigns = languageassigns;
	}
	public List<contributor_Role> getContributor_Roles() {
		return contributor_Roles;
	}
	public void setContributor_Roles(List<contributor_Role> contributor_Roles) {
		this.contributor_Roles = contributor_Roles;
	}
	public List<Tutorial> getTutorial() {
		return tutorial;
	}
	public void setTutorial(List<Tutorial> tutorial) {
		this.tutorial = tutorial;
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
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
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
	public Set<commentOnComponent> getCommentOnComponent() {
		return commentOnComponent;
	}
	public void setCommentOnComponent(Set<commentOnComponent> commentOnComponent) {
		this.commentOnComponent = commentOnComponent;
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
	public void setId(Long id) {
		this.id = id;
	}


}
