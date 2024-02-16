package com.talktherapy.service;

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
}
