package com.health.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tranieeInfo")
public class traineeInformation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "trainee_id", nullable = false)
	public int getId() 
	{
		return id;
	}

	/*
	 * @ManyToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name="user_id") private User user;
	 */
	
	public void setId(int id) {
		this.id = id;
	}
	private int id;
	private String name;
	private String age;
	private String mobileNumber;
	private String address;
	private String organization ;
	private String experience;
	private String premark;
	private String postmark;
	


	private String aadharNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getPremark() {
		return premark;
	}

	public void setPremark(String premark) {
		this.premark = premark;
	}

	public String getPostmark() {
		return postmark;
	}

	public void setPostmark(String postmark) {
		this.postmark = postmark;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	
	
	
}
