package com.example.EventManagementPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping
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