package com.talktherapy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talktherapy.model.Appointment;

@Repository
public interface AdminRepository extends JpaRepository<Appointment, String>{

	Optional<Appointment> findByEmail(String email);

}
