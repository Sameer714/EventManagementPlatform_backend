package com.example.EventManagementPlatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EventManagementPlatform.exception.DuplicateUsernameException;
import com.example.EventManagementPlatform.model.Event;
import com.example.EventManagementPlatform.repository.EventRepo;

@Service
public class EventService {
	@Autowired
	EventRepo eventRepo;
	
	public Event saveEvent(Event event) throws DuplicateUsernameException {
	    if (eventRepo.findByEventName(event.getEventName()) != null) {
	        throw new DuplicateUsernameException("Event name already exists!", "Duplicate:");
	    }
	    if (eventRepo.findByEventDateAndLocation(event.getEventDate(), event.getLocation()) != null) {
	        throw new DuplicateUsernameException("An event is already happening at the same place on the same day!", "Duplicate:");
	    }
	    return eventRepo.save(event);
	}
	
	public List<Event> getAllEvents (){
		return eventRepo.findAll();
	}

	public Optional<Event> getEvent(Long id) {
		return eventRepo.findById(id);
	}
}