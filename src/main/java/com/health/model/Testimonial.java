package com.health.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.context.properties.ConfigurationProperties;


@Entity
public class Testimonial {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private  int id;
		private String testimonialName;
		private String testimoniaqlDescription;
		private String uploadTestiminial;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTestimonialName() {
			return testimonialName;
		}
		public void setTestimonialName(String testimonialName) {
			this.testimonialName = testimonialName;
		}
		public String getUploadTestiminial() {
			return uploadTestiminial;
		}
		public void setUploadTestiminial(String uploadTestiminial) {
			this.uploadTestiminial = uploadTestiminial;
		}
		public String getTestimoniaqlDescription() {
			return testimoniaqlDescription;
		}
		public void setTestimoniaqlDescription(String testimoniaqlDescription) {
			this.testimoniaqlDescription = testimoniaqlDescription;
		}
		
		
}


