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
public class Testimonial {
	
	@Id
	@Column(name = "testi_id",updatable = false,nullable = false)
	private int testimonialId;
	
	@Column(name = "name", nullable = false)
	private String name ;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "filePath", nullable = false)
	private String filePath;
	
	@Column(name = "date_added", nullable = false)
	private Timestamp dateAdded;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public int getTestimonialId() {
		return testimonialId;
	}

	public void setTestimonialId(int testimonialId) {
		this.testimonialId = testimonialId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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

//		@Id
//		@GeneratedValue(strategy = GenerationType.AUTO)
//		private  int id;
//		private String testimonialName;
//		@Column(length = 3000)
//		private String testimoniaqlDescription;
//		private String uploadTestiminial;
//		private java.sql.Timestamp timedate;
//
//
//
//		public java.sql.Timestamp getTimedate() {
//			return timedate;
//		}
//		public void setTimedate(java.sql.Timestamp timedate) {
//			this.timedate = timedate;
//		}
//
//		public int getId() {
//			return id;
//		}
//		public void setId(int id) {
//			this.id = id;
//		}
//		public String getTestimonialName() {
//			return testimonialName;
//		}
//		public void setTestimonialName(String testimonialName) {
//			this.testimonialName = testimonialName;
//		}
//		public String getUploadTestiminial() {
//			return uploadTestiminial;
//		}
//		public void setUploadTestiminial(String uploadTestiminial) {
//			this.uploadTestiminial = uploadTestiminial;
//		}
//		public String getTestimoniaqlDescription() {
//			return testimoniaqlDescription;
//		}
//		public void setTestimoniaqlDescription(String testimoniaqlDescription) {
//			this.testimoniaqlDescription = testimoniaqlDescription;
//		}



}


