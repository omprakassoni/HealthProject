
  package com.health.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

	@Entity 
  public class language 
  {
  
  @Id  
  @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable = false, updatable = false)
  private int id;
 
  private  String languageName ;
  private String date;

	  
	
	  @OneToMany(mappedBy = "lan",cascade =CascadeType.ALL) 
	  private List<Tutorial> tutorials;
	  
	


	public List<Tutorial> getTutorials() {
		return tutorials;
	}

	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}



	public String getDate() {
		return date;
	  }
	
	
	  public void setDate(String date) {
		this.date = date;
		}
	
	
		public int getId() { 
		  return id; }
	  
	 
	  public void setId(int id) { 
		  this.id = id; }
	  
	 
	  public String getLanguageName() { 
		  return languageName; }
	  
	
	
	  public void setLanguageName(String languageName) 
	  { this.languageName =
	  languageName; }
	  

 
  }
 