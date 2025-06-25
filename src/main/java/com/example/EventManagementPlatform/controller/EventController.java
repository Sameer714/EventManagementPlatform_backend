package com.example.EventManagementPlatform.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EventManagementPlatform.exception.DuplicateUsernameException;
import com.example.EventManagementPlatform.model.Event;
import com.example.EventManagementPlatform.service.EventService;

@RestController
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@GetMapping("/getAllEvents")
	public List<Event> getAllEvents(){
		return eventService.getAllEvents();
	}
	
	@GetMapping("/getEvent")
	public Optional<Event> getEvent(Long id){
		return eventService.getEvent(id);
	}
	
	@PostMapping("/events")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ORGANIZER')")
	public ResponseEntity<Object> saveEvent (@RequestBody Event event) {
		try {
			eventService.saveEvent(event);
		}
		catch(DuplicateUsernameException e) {
			return ResponseEntity.status(HttpStatus.OK)
					.body("{\"message\": \"" + e.getMessage() + "\" , \"Success\": \"" + "false" + "\"}");
		}
		return null;
	}	
}