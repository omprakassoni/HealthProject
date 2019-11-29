package com.health.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.health.domain.security.Role;

@Entity
@Table(name="cat_tutorial")
public class category_Tutorial {

	public category_Tutorial(Category cat) {
		super();
		this.cat = cat;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long catLanId;
	

	public Long getCatLanId() {
		return catLanId;
	}


	public void setCatLanId(Long catLanId) {
		this.catLanId = catLanId;
	}

	public category_Tutorial() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}


	public Tutorial getTutorial() {
		return tutorial;
	}

	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}

	public category_Tutorial(Category cat, Tutorial tutorial){
		this.cat = cat;
		this.tutorial = tutorial;
	}
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name="category_id")
	private Category cat;
	
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name="language_id")
	private Tutorial tutorial;
	

}
