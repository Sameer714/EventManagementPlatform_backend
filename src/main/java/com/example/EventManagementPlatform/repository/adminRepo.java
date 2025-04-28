package com.example.EventManagementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EventManagementPlatform.model.Admin;
@Repository
public interface adminRepo extends JpaRepository<Admin, Long>{
	Admin findById(long id);
	Admin findByEmail(String email);
	Admin findByUsername(String userName);
}
