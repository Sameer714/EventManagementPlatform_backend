package com.example.EventManagementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EventManagementPlatform.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	User findById(long userId);
	User findByEmail(String email);
	User findByuserName(String userName);
}