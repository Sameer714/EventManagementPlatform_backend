package com.example.EventManagementPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EventManagementPlatform.exception.DuplicateUsernameException;
import com.example.EventManagementPlatform.model.User;
import com.example.EventManagementPlatform.others.PasswordChecker;
import com.example.EventManagementPlatform.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public User getAdminInfo(long userId) {
		User u = userRepo.findById(userId);
		return u;
	}
	
	public User saveAdmin(User user) throws DuplicateUsernameException{
		User isUserPresent = userRepo.findByEmail(user.getEmail());
		if(isUserPresent == null) {
			User u = new User();
			u.setEmail(user.getEmail());
			User isUsernmPresent = userRepo.findByuserName(user.getUserName());
			if(isUsernmPresent == null) {
				u.setUserName(user.getUserName());	
			}else {
				throw new DuplicateUsernameException("Username Already Exists", "Duplicate :");
		}
			if (user.getRole().equalsIgnoreCase("ADMIN")) {
				u.setStatus("INACTIVE");
			} else if (user.getRole().equalsIgnoreCase("Organizer")){
				u.setStatus("INACTIVE");
			}else {
				u.setStatus("ACTIVE");
			}
			u.setRole("ROLE_" + user.getRole());
			
			if (user.getPass().isEmpty()) {
				throw new DuplicateUsernameException("Enter Password!", "Invalid : ");

			} else {
				PasswordChecker passwordChecker = new PasswordChecker();
				if (passwordChecker.isValid(user.getPass())) {
					u.setPass(user.getPass());
					u.setName(user.getName());
					return userRepo.save(u);
				} else {
					throw new DuplicateUsernameException("Password doesn't follow our criteria!", "Invalid : ");
				}
			}
		}
		throw new DuplicateUsernameException("Email id Already Registered!", "Duplicate :");
	}
	
	public User updateAdmin (User user , long id) throws DuplicateUsernameException{
		
		User u = userRepo.findById(id);
		u.setName(user.getName());
		User isUserPresent = userRepo.findByEmail(u.getEmail());
		
		if (isUserPresent != null) {
			User isusrnmPresent = userRepo.findByuserName(user.getUserName());
			if (isusrnmPresent == null) {
				u.setUserName(user.getUserName());
			} else {
				u.setUserName(user.getUserName());
			}
			
			u.setEmail(user.getEmail());
			u.setRole("ROLE_" + user.getRole());
			if (!u.getPass().isEmpty()) {
				PasswordChecker passwordChecker = new PasswordChecker();
				if (passwordChecker.isValid(user.getPass())) {
					u.setPass(user.getPass());
					return userRepo.save(u);
				} else {
					u.setPass(u.getPass());
					return userRepo.save(u);
				}
			}
		}
		throw new DuplicateUsernameException("Email Not Registered!", "Not Found:");
	}
}