package com.example.EventManagementPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EventManagementPlatform.model.Registration;
import com.example.EventManagementPlatform.service.RegistrationService;

@RestController
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;
	
	@PostMapping("/register")
	public Registration registerToEvent (@RequestBody Registration registration) {
		return registrationService.register(registration);
	}
}