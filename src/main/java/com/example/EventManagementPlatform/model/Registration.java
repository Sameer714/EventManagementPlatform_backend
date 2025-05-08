package com.example.EventManagementPlatform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long userId;
	private Long eventId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	@Override
	public String toString() {
		return "Registration [id=" + id + ", userId=" + userId + ", eventId=" + eventId + "]";
	}
	public Registration(Long id, Long userId, Long eventId) {
		super();
		this.id = id;
		this.userId = userId;
		this.eventId = eventId;
		
	}
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
}