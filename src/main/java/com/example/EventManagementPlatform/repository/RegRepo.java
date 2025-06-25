package com.example.EventManagementPlatform.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EventManagementPlatform.model.Registration;

@Repository
public interface RegRepo extends JpaRepository<Registration, Long> {
	Optional<Registration> findByUserIdAndEventId(Long userId, Long eventId);
}