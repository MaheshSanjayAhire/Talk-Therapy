package com.talktherapy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;

import com.talktherapy.model.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, String>{

}
