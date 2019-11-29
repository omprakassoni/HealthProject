package com.health.model;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class TraningInformation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String topicTraning;
	private String language;
	private String state;
	private String pincode;
	private String participant;
	private String photo;
	private Timestamp date;
	
	

	public int getId() {
		return id;	
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopicTraning() {
		return topicTraning;
	}

	public void setTopicTraning(String topicTraning) {
		this.topicTraning = topicTraning;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getParticipant() {
		return participant;
	}

	public void setParticipant(String participant) {
		this.participant = participant;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
	
	
}
