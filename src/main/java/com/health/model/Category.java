package com.health.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="id", nullable = false, updatable = false)
	private int id;
	private String categoryname;
	
	@OneToMany(mappedBy = "cat", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<category_Tutorial> category_Tutorials=new HashSet<>();

	
	
	
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

	public Set<category_Tutorial> getCategory_Tutorials() {
		return category_Tutorials;
	}

	public void setCategory_Tutorials(Set<category_Tutorial> category_Tutorials) {
		this.category_Tutorials = category_Tutorials;
	}
	
	

}
