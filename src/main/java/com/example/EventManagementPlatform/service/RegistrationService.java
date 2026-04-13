package com.example.EventManagementPlatform.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.EventManagementPlatform.exception.DuplicateUsernameException;
import com.example.EventManagementPlatform.model.Event;
import com.example.EventManagementPlatform.model.Registration;
import com.example.EventManagementPlatform.repository.EventRepo;
import com.example.EventManagementPlatform.repository.RegRepo;

@Service
public class RegistrationService {
	@Autowired
	RegRepo regRepo;
	
	@Autowired
	EventRepo eventRepo;
	
	Event event;
	
	public ResponseEntity<Object> register (Registration registration) throws DuplicateUsernameException {
		try {
		 Optional<Registration> existing = regRepo.findByUserIdAndEventId(registration.getUserId(), registration.getEventId());
		    
		    if (existing.isPresent()) {
				throw new DuplicateUsernameException("User Already Registered for this event", "Already registered ");
		    }
		    Event ev = eventRepo.findById(registration.getEventId())
		    		.orElseThrow(() -> new DuplicateUsernameException("Event Not Found", " : "));
		    

		    if (ev.getCapacity() <= 0) {
				throw new DuplicateUsernameException("No Seats Left for this event", "Full : ");
		    }
		    else {
			    ev.setCapacity(ev.getCapacity()-1);
			    eventRepo.save(ev);
		    }
		    
		    if(regRepo.save(registration) != null) {
		    	return ResponseEntity.status(HttpStatus.OK)
		    	    .body("{\"message\": \"Registration successful\", \"success\": \"true\"}");
		    }
	}
	
	catch (DuplicateUsernameException e) {
		return ResponseEntity.status(HttpStatus.OK)
				.body("{\"message\": \"" + e.getMessage() + "\" , \"Success\": \"" + "false" + "\"}");
	}
		return null;
	}
}