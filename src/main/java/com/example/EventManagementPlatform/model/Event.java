package com.example.EventManagementPlatform.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "EventId")
	private Long EventId;
	
	private String EventName;
	private LocalDateTime EventDate;
	private String Location;
	private int Capacity;
	private int Duration;
	private Long getOrgIdLong;
	public Long getEventId() {
		return EventId;
	}
	public void setEventId(Long eventId) {
		EventId = eventId;
	}
	public String getEventName() {
		return EventName;
	}
	public void setEventName(String eventName) {
		EventName = eventName;
	}
	public LocalDateTime getEventDate() {
		return EventDate;
	}
	public void setEventDate(LocalDateTime eventDate) {
		EventDate = eventDate;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public int getCapacity() {
		return Capacity;
	}
	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
	public int getDuration() {
		return Duration;
	}
	public void setDuration(int duration) {
		Duration = duration;
	}
	public Long getGetOrgIdLong() {
		return getOrgIdLong;
	}
	public void setGetOrgIdLong(Long getOrgIdLong) {
		this.getOrgIdLong = getOrgIdLong;
	}
	@Override
	public String toString() {
		return "Event [EventId=" + EventId + ", EventName=" + EventName + ", EventDate=" + EventDate + ", Location="
				+ Location + ", Capacity=" + Capacity + ", Duration=" + Duration + ", getOrgIdLong=" + getOrgIdLong
				+ "]";
	}
	public Event(Long eventId, String eventName, LocalDateTime eventDate, String location, int capacity, int duration,
			Long getOrgIdLong) {
		super();
		EventId = eventId;
		EventName = eventName;
		EventDate = eventDate;
		Location = location;
		Capacity = capacity;
		Duration = duration;
		this.getOrgIdLong = getOrgIdLong;
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
}
