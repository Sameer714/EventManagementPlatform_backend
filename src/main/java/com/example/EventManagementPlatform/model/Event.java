package com.example.EventManagementPlatform.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;

    private String eventName;
    private LocalDateTime eventDate;
    private String location;
    private int capacity;
    private int duration;
    private String eventStatus;

    @Column(name = "organizer_id")
    private Long organizerId; 

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public String getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    public Event() {
    }

	public Event(Long eventId, String eventName, LocalDateTime eventDate, String location, int capacity, int duration,
			String eventStatus, Long organizerId) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.location = location;
		this.capacity = capacity;
		this.duration = duration;
		this.eventStatus = eventStatus;
		this.organizerId = organizerId;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", eventDate=" + eventDate + ", location="
				+ location + ", capacity=" + capacity + ", duration=" + duration + ", eventStatus=" + eventStatus
				+ ", organizerId=" + organizerId + "]";
	}
}