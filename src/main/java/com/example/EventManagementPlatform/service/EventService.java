package com.example.EventManagementPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EventManagementPlatform.exception.DuplicateUsernameException;
import com.example.EventManagementPlatform.model.Event;
import com.example.EventManagementPlatform.repository.EventRepo;

@Service
public class EventService {
	@Autowired
	EventRepo eventRepo;
	
	public Event saveEvent (Event event) throws DuplicateUsernameException{
		Event isEventNamePresent = eventRepo.findByEventName(event.getEventName());
		if(isEventNamePresent == null) {
			Event e = new Event();
			e.setEventName(event.getEventName());
			Event isEventGenuine = eventRepo.findByEventDateAndLocation(event.getEventDate(),event.getLocation());
			if(isEventGenuine == null) {
				e.setEventDate(event.getEventDate());
				e.setLocation(event.getLocation());
			}
			else {
				throw new DuplicateUsernameException("A event is already happeneing at same place on the same day!", "Duplicate :");
			}
			e.setCapacity(event.getCapacity());
			e.setDuration(event.getDuration());
			return eventRepo.save(e);

		}
		else {
			throw new DuplicateUsernameException("Username Already Exists", "Duplicate :");
			}
}
}