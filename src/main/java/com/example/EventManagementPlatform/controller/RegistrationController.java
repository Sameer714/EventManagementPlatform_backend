package com.example.EventManagementPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EventManagementPlatform.exception.DuplicateUsernameException;
import com.example.EventManagementPlatform.model.Registration;
import com.example.EventManagementPlatform.service.RegistrationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;
	
	@PostMapping("/register")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ORGANIZER','ROLE_USER')")

	public ResponseEntity<Object> registerToEvent (@RequestBody Registration registration) throws DuplicateUsernameException {
		return registrationService.register(registration);
	}
} 