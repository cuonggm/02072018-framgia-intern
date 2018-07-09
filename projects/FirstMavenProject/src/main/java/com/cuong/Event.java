package com.cuong;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Event {
	private Set participants = new HashSet();
	
	private Long id;
	
	private String title;
	private Date date;
	
	public Event() {
		super();
	}

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set getParticipants() {
		return participants;
	}

	public void setParticipants(Set participants) {
		this.participants = participants;
	}
	
}
