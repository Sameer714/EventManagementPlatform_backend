package com.example.EventManagementPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.EventManagementPlatform.Security.JwtHelper;
import com.example.EventManagementPlatform.model.JwtRequest;
import com.example.EventManagementPlatform.model.JwtResponse;
import com.example.EventManagementPlatform.model.User;
import com.example.EventManagementPlatform.repository.UserRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
        JwtResponse response = new JwtResponse();

        User user = userRepo.findByEmail(request.getGmail());
        if (user != null) {
            if (user.getPassword().equals(request.getPassw())) {
                String token = jwtHelper.generateToken(user);  
                response.setJwtoken(token);
                response.setUsernm(user.getUserName());
                response.setRole(user.getRole());
                response.setId(user.getUserId());
            } else {
                response.setUsernm(user.getUsername()); 
            }
        } else {
            response.setUsernm(request.getGmail());  
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}