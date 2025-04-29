package com.example.EventManagementPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EventManagementPlatform.exception.DuplicateUsernameException;
import com.example.EventManagementPlatform.model.Admin;
import com.example.EventManagementPlatform.others.passwordChecker;
import com.example.EventManagementPlatform.repository.adminRepo;

@Service
public class adminService {
	@Autowired
	private adminRepo adminRepo;
	
	
	public Admin getAdminInfo(long adminId) {
		Admin a = adminRepo.findById(adminId);
		return a;
	}
	
	public Admin saveAdmin(Admin admin) throws DuplicateUsernameException{
		Admin isAdminPresent = adminRepo.findByEmail(admin.getEmail());
		if(isAdminPresent == null) {
			Admin a = new Admin();
			a.setEmail(a.getEmail());
			Admin isUsernmPresent = adminRepo.findByUsername(a.getUserName());
			if(isUsernmPresent == null) {
				a.setUserName(a.getUserName());	
			}else {
				throw new DuplicateUsernameException("Username Already Exists", "Duplicate :");
		}
			if (admin.getRole().equalsIgnoreCase("ADMIN")) {
				a.setStatus("INACTIVE");
			} else {
				a.setStatus("ACTIVE");
			}
			a.setRole("ROLE_" + admin.getRole());
			
			if (a.getPass().isEmpty()) {
				throw new DuplicateUsernameException("Enter Password!", "Invalid : ");

			} else {
				passwordChecker passwordChecker = new passwordChecker();
				if (passwordChecker.isValid(a.getPass())) {
					a.setPass(a.getPass());
//					u.setPass(passwordEncoder.encode(user.getPassword()));
					return adminRepo.save(a);
				} else {
					throw new DuplicateUsernameException("Password doesn't follow our criteria!", "Invalid : ");
				}
			}
		}
		throw new DuplicateUsernameException("Email id Already Registered!", "Duplicate :");
	}
	
	
	
	public Admin updateAdmin (Admin admin , long id) throws DuplicateUsernameException{
		Admin a = adminRepo.findById(id);
		a.setName(admin.getName());
		Admin isAdminPresent = adminRepo.findByEmail(a.getEmail());
		if (isAdminPresent != null) {
			Admin isusrnmPresent = adminRepo.findByUsername(admin.getUserName());
			if (isusrnmPresent == null) {
				a.setUserName(a.getUserName());
			} else {
				a.setUserName(a.getUserName());
			}
			a.setEmail(a.getEmail());
			a.setRole("ROLE_" + a.getRole());
			if (!a.getPass().isEmpty()) {
				passwordChecker passwordChecker = new passwordChecker();
				if (passwordChecker.isValid(a.getPass())) {
					a.setPass(a.getPass());
					return adminRepo.save(a);
				} else {
					a.setPass(a.getPass());
					return adminRepo.save(a);

				}
			}
		}
		throw new DuplicateUsernameException("Email Not Registered!", "Not Found:");
	}
}

		
//		Admin a = adminRepo.save(admin);
//		return a;
