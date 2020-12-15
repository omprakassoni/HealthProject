package com.health.model;

import java.sql.Date;
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

@Entity
public class TrainingInformation{

	@Id
	private int trainingId;
	
	@Column(name = "totalParticipant")
	private int totalParticipant;
	
	@Column(name = "pincode")
	private int pincode;
	
	@Column(name= "PosterPath")
	private String posterPath;
	
	@Column(name= "startDate")
	private Date startDate;
	
	@Column(name= "endDate")
	private Date enddate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="topicCat_id")
	private TopicCategoryMapping topicCatId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="state_id")
	private Language lan;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="lan_id")
	private State state;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="district_id")
	private District district;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
		
	@Column(name = "title")
	private String titleName;
	
	@Column(name = "date_added", nullable = false)
	private Timestamp dateAdded;
	
	@Column(name = "address" ,length = 10000)
	private String address;
	
	@OneToMany(mappedBy = "traineeInfos" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<TraineeInformation> traineeInfos= new HashSet<TraineeInformation>();

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public int getTotalParticipant() {
		return totalParticipant;
	}

	public void setTotalParticipant(int totalParticipant) {
		this.totalParticipant = totalParticipant;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public TopicCategoryMapping getTopicCatId() {
		return topicCatId;
	}

	public void setTopicCatId(TopicCategoryMapping topicCatId) {
		this.topicCatId = topicCatId;
	}

	public Language getLan() {
		return lan;
	}

	public void setLan(Language lan) {
		this.lan = lan;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public Timestamp getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Timestamp dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<TraineeInformation> getTraineeInfos() {
		return traineeInfos;
	}

	public void setTraineeInfos(Set<TraineeInformation> traineeInfos) {
		this.traineeInfos = traineeInfos;
	}




}