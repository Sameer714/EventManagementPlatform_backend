package com.example.EventManagementPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EventManagementPlatform.model.Registration;
import com.example.EventManagementPlatform.repository.RegRepo;

@Service
public class RegistrationService {
	@Autowired
	RegRepo regRepo;
	
	public Registration register (Registration registration) {
		Registration r = new Registration();
		r.setEventId(registration.getEventId());
		r.setUserId(registration.getUserId());
		return regRepo.save(r);
	}
}