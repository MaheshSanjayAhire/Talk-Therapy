package com.talktherapy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;

import com.talktherapy.model.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, String>{
	
	// @Query()
	List<Appointment> findAllByUsername(String username);
	
	List<Appointment> findAllByEmail(String email);

	List<Appointment> getUserByEmail(String email);

}