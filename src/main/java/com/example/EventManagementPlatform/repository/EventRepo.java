package com.example.EventManagementPlatform.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EventManagementPlatform.model.Event;

@Repository
public interface EventRepo extends JpaRepository<Event, Long>{
	Event findByEventName(String eventName);
	Event findByEventDateAndLocation(LocalDateTime eventDate , String location);
	List<Event> findAll();
	Optional<Event> findById(Long id);
}