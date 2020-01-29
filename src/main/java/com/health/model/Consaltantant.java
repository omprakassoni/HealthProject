package com.health.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Consaltantant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id                    ;
	private String nameConsaltant;
	private String descriptionConsaltant;
	private String uploadConsaltantImage;

	public String getNameConsaltant() {
		return nameConsaltant;
	}
	public void setNameConsaltant(String nameConsaltant) {
		this.nameConsaltant = nameConsaltant;
	}
	public String getDescriptionConsaltant() {
		return descriptionConsaltant;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDescriptionConsaltant(String descriptionConsaltant) {
		this.descriptionConsaltant = descriptionConsaltant;
	}
	public String getUploadConsaltantImage() {
		return uploadConsaltantImage;
	}
	public void setUploadConsaltantImage(String uploadConsaltantImage) {
		this.uploadConsaltantImage = uploadConsaltantImage;
	}
	
}
