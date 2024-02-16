package com.talktherapy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talktherapy.model.Appointment;
import com.talktherapy.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adrepo;
	
	public List<Appointment> getAllapp()
	{
		return adrepo.findAll();
	}
	
	public Appointment getByuname(String username)
	{
		Optional<Appointment> a=adrepo.findById(username);
		if(a.isPresent())
		{
			return a.get();
		}
		return null;
	}
	
	public void addApp(Appointment a)
	{
		adrepo.save(a);
	}
	
	public boolean validateAdmin(String email, String password)
	{
		return email.equalsIgnoreCase("admin@123") && password.equalsIgnoreCase("admin@123");
	}
}
