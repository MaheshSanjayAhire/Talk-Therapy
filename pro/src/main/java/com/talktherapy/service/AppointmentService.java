package com.talktherapy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talktherapy.model.Appointment;
import com.talktherapy.repository.AppointmentRepo;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepo repo;
	
	public void addApp(Appointment a)
	{
		repo.save(a);
	}
	
	public void deleteApp(String username) {
		repo.deleteById(username);
	}
	
	public List<Appointment> getUserByEmail(String email)
	{
		List<Appointment> appt=repo.findAllByEmail(email);
		return appt;
	}
}
