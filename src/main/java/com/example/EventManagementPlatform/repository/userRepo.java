package com.example.EventManagementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EventManagementPlatform.model.User;

@Repository
public interface userRepo extends JpaRepository<User, Long>{

}