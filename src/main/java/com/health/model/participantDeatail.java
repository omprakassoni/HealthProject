package com.health.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class participantDeatail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int participantId;
	private String name;
	private Long addarid;

	@OneToOne
	private TraningInformation TraningInformation;
	
	public int getParticipantId() {
		return participantId;
	}

	
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAddarid() {
		return addarid;
	}
	public void setAddarid(Long addarid) {
		this.addarid = addarid;
	}
	

}
