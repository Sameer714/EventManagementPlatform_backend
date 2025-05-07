package com.example.EventManagementPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EventManagementPlatform.exception.DuplicateUsernameException;
import com.example.EventManagementPlatform.model.User;
import com.example.EventManagementPlatform.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<Object> saveAdmin(@RequestBody User user) {
		try {
			User saveAdmin = userService.saveAdmin(user);
			if (saveAdmin != null) {
				if (saveAdmin.getRole().equalsIgnoreCase("ROLE_ADMIN")) {
					return ResponseEntity.status(HttpStatus.OK)
							.body("{\"message\": \"" + "User Saved Successfully , Wait for Admin Approval!"
									+ "\" ,  \"Success\": \"" + "true" + "\"}");
				}
				else if (saveAdmin.getRole().equalsIgnoreCase("ROLE_USER")) {
					return ResponseEntity.status(HttpStatus.OK).body(
							"{\"message\": \"" + "User Saved Successfully" + "\" ,  \"Success\": \"" + "true" + "\"}");
				}
				else if (saveAdmin.getRole().equalsIgnoreCase("ROLE_ORGANIZER")) {
					return ResponseEntity.status(HttpStatus.OK)
							.body("{\"message\": \"" + "User Saved Successfully , Wait for Admin Approval!"
									+ "\" ,  \"Success\": \"" + "true" + "\"}");
				}
			}
		}		
		catch (DuplicateUsernameException e) {
			return ResponseEntity.status(HttpStatus.OK)
					.body("{\"message\": \"" + e.getMessage() + "\" , \"Success\": \"" + "false" + "\"}");
		}
		return null;
	}
}