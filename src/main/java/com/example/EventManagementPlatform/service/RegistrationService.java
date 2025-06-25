package com.example.EventManagementPlatform.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EventManagementPlatform.model.Registration;
import com.example.EventManagementPlatform.repository.RegRepo;

@Service
public class RegistrationService {
	@Autowired
	RegRepo regRepo;
	
	public Registration register (Registration registration) {
		 Optional<Registration> existing = regRepo.findByUserIdAndEventId(registration.getUserId(), registration.getEventId());
		    
		    if (existing.isPresent()) {
		        throw new IllegalStateException("User already registered for this event");
		    }

		    return regRepo.save(registration);
	}
}