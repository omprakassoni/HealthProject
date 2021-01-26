package com.health.model;

import java.sql.Date;
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

@Entity
public class Event {
	
	@Id
	@Column(name = "event_id",updatable = false,nullable = false)
	private int eventId;
	
	@Column(name = "event_name", nullable = false)
	private String eventName;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "location", nullable = false)
	private String location;
	
	@Column(name = "contactPerson", nullable = false)
	private String contactPerson;
	
	@Column(name = "contactNumber", nullable = false)
	private long contactNumber;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "path", nullable = false)
	private String posterPath;
	
	@Column(name = "start_Date", nullable = false)
	private Date startDate ;
	
	@Column(name = "end_date", nullable = false)
	private Date endDate ;
	
	@Column(name = "date_added", nullable = false)
	private Timestamp dateAdded;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<TrainingInformation> trainings =new HashSet<TrainingInformation>();

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Timestamp getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Timestamp dateAdded) {
		this.dateAdded = dateAdded;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public Set<TrainingInformation> getTrainings() {
		return trainings;
	}

	public void setTrainings(Set<TrainingInformation> trainings) {
		this.trainings = trainings;
	}
	
	

	
	

}
