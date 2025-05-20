package com.example.EventManagementPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EventManagementPlatform.model.GlobalInput.Emailbody;
import com.example.EventManagementPlatform.service.ContactSender;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ContactController {
	
	@Autowired
	private ContactSender contactSender;

    @PostMapping("/send")
    public ResponseEntity<String> sendContactForm(@RequestBody Emailbody emailbody) {
        try {
            contactSender.sendMail(emailbody);
            return ResponseEntity.ok("Email sent successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to send email: " + e.getMessage());
        }
    }
}