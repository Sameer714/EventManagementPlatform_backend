package com.example.EventManagementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EventManagementPlatform.model.Organizer;

@Repository
public interface organizerRepo extends JpaRepository<Organizer, Long> {

}