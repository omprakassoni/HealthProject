package com.health.model;

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
public class City {

	@Id
	@Column(name = "city_id", nullable = false)
	private int id;
	
	private Timestamp dateAdded;
	
	private String cityName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="district_id")
	private District district;
	
	@OneToMany(mappedBy = "city",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<TrainingInformation> trainingInfo =new HashSet<TrainingInformation>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Timestamp dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Set<TrainingInformation> getTrainingInfo() {
		return trainingInfo;
	}

	public void setTrainingInfo(Set<TrainingInformation> trainingInfo) {
		this.trainingInfo = trainingInfo;
	}
	
	


	
	
	
}
