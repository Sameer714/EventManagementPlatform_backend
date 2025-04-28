package com.example.EventManagementPlatform.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EventManagementPlatform.exception.DuplicateUsernameException;
import com.example.EventManagementPlatform.model.Admin;
import com.example.EventManagementPlatform.others.pass;
import com.example.EventManagementPlatform.service.adminService;


@RestController
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/v1/api")
public class adminController {
	
	@Autowired
	adminService adminService;
	
	@PostMapping(value = "/createuser", produces = "application/json")
	public ResponseEntity<Object> saveUser(@RequestBody Admin admin) {
		try {
			adminService.saveAdmin(admin);
		} 
		catch (DuplicateUsernameException e) {
			return ResponseEntity.status(HttpStatus.OK)
					.body("{\"message\": \"" + e.getMessage() + "\" , \"Success\": \"" + "false" + "\"}");
		}
		
		return null;
	}
	
//	@PostMapping("/changePass")
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
//	public ResponseEntity<String> changepass(@RequestBody pass pass) {
//		return adminService.changePass(pass.getEmail(), pass.getOldpass(), pass.getPass());
//	}
	
}