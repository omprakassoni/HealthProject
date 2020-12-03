package com.health.model;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contactForm")
public class ContactForm {
	
	
	@Id
	@Column(name = "contact_id",nullable = false, updatable = false)
	private int contactFormId;
	
	@Column(name = "name",nullable = false)
	private String name;
	
	@Column(name = "message",nullable = false,length = 1000)
	private String message;
	
	@Column(name = "email",nullable = false)
	private String email;
	
	@Column(name = "date_added", nullable = false)
	private Timestamp dateAdded;

	public int getContactFormId() {
		return contactFormId;
	}

	public void setContactFormId(int contactFormId) {
		this.contactFormId = contactFormId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Timestamp dateAdded) {
		this.dateAdded = dateAdded;
	}
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private  int id;
//	
//	private String name;
//	private String email;
//	private String description;
//	private String subject;
//
//	public String getSubject() {
//		return subject;
//	}
//
//	public void setSubject(String subject) {
//		this.subject = subject;
//	}
//	private Date datetime; 
//	
//	//private Date vardates;
//	
//	public int getId() {
//		return id;
//	}
//
//
//
//	public Date getDatetime() {
//		return datetime;
//	}
//
//	public void setDatetime(Date datetime) {
//		this.datetime = datetime;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}

	
	
	
}
