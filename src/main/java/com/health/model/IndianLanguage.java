package com.health.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class IndianLanguage {

	@Id
	private int id;
	
	private String lanName;
	
	@OneToMany(mappedBy = "indianlan", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<UserIndianLanguageMapping> userLans = new HashSet<UserIndianLanguageMapping>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanName() {
		return lanName;
	}

	public void setLanName(String lanName) {
		this.lanName = lanName;
	}

	public Set<UserIndianLanguageMapping> getUserLans() {
		return userLans;
	}

	public void setUserLans(Set<UserIndianLanguageMapping> userLans) {
		this.userLans = userLans;
	}
	
	
}
