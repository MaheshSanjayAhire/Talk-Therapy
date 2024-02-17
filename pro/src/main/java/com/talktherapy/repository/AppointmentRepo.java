package com.talktherapy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.talktherapy.model.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, String>{

	//List<Appointment> findAllByEmail(String email);
	//@Query("SELECT a FROM Appointment a WHERE a.email = :email")
    List<Appointment> findByEmail(String email);

	List<Appointment> findAllByEmail(String email);
}
