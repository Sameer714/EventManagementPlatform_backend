package com.example.EventManagementPlatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EventManagementPlatform.model.Organizer;

@Repository
public interface OrganizerRepo extends JpaRepository<Organizer, Long> {
	List<Organizer> findAllByStatus(String status);
	List<Organizer> findAll();

}