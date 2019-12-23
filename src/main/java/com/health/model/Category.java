package com.health.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name="id")
	@Column(name="id", nullable = false, updatable = false)
	private int id;
	private String categoryname;

	
	  @OneToMany(mappedBy = "category",cascade =CascadeType.ALL) private
	  List<Tutorial> tutorials;
	  

	  @OneToMany(mappedBy = "category",cascade =CascadeType.ALL) 
	  private List<topic>  topic;
	  
	  
	  @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
		 private List<TraningInformation> traningInformations;
		 
	  
		public List<topic> getTopic() {
			return topic;
		}

		public void setTopic(List<topic> topic) {
			this.topic = topic;
		}
	 
	public List<Tutorial> getTutorials() {
		return tutorials;
	}

	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

}
