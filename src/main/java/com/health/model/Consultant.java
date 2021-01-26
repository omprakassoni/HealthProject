package com.health.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Consultant{
	
	@Id
	@Column(name = "consult_id",updatable = false,nullable = false)
	private int consultantId;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "date_added", nullable = false)
	private Timestamp dateAdded;
	
	@Column(name = "showonhomepage", nullable = false)
	private boolean onHome = false;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	public int getConsultantId() {
		return consultantId;
	}

	public void setConsultantId(int consultantId) {
		this.consultantId = consultantId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Timestamp getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Timestamp dateAdded) {
		this.dateAdded = dateAdded;
	}

	public boolean isOnHome() {
		return onHome;
	}

	public void setOnHome(boolean onHome) {
		this.onHome = onHome;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//
//
//	private int id                    ;
//	private String nameConsaltant;
//	private String descriptionConsaltant;
//	private String uploadConsaltantImage;
//	private String currentdate;
//	private java.sql.Timestamp timedate;
//	private Boolean showOnHomepage;
//
//
//
//
//	public Timestamp getTimaedate() {
//		return timedate;
//	}
//	public void setTimaedate(Timestamp timaedate) {
//		this.timedate = timaedate;
//	}
//	public String getCurrentdate() {
//		return currentdate;
//	}
//	public void setCurrentdate(String currentdate) {
//		this.currentdate = currentdate;
//	}
//	public String getNameConsaltant() {
//		return nameConsaltant;
//	}
//	public void setNameConsaltant(String nameConsaltant) {
//		this.nameConsaltant = nameConsaltant;
//	}
//	public String getDescriptionConsaltant() {
//		return descriptionConsaltant;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public void setDescriptionConsaltant(String descriptionConsaltant) {
//		this.descriptionConsaltant = descriptionConsaltant;
//	}
//	public String getUploadConsaltantImage() {
//		return uploadConsaltantImage;
//	}
//	public void setUploadConsaltantImage(String uploadConsaltantImage) {
//		this.uploadConsaltantImage = uploadConsaltantImage;
//	}
//	public Boolean getShowOnHomepage() {
//		return showOnHomepage;
//	}
//	public void setShowOnHomepage(Boolean showOnHomepage) {
//		this.showOnHomepage = showOnHomepage;
//	}


}
