package com.talktherapy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.talktherapy.model.Appointment;
import com.talktherapy.service.AdminService;
import com.talktherapy.service.AppointmentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	@Autowired
	private AdminService adservice;
	@Autowired
	private AppointmentService aservice;
	
	@GetMapping("/admin")
	public String showall(Model m)
	{
		List<Appointment> adm=adservice.getAllapp();
		m.addAttribute("appts", adm);
		return "AdminDashBoard";
	}
	
	@GetMapping("/edit/{username}")
	public String linkJoin(@PathVariable String username,Model m)
	{
		Appointment a=adservice.getByuname(username);
		m.addAttribute("uname",a);
		return "AdminAppConfirm";
	}
	
	@PostMapping("/confirmed")
	public String confirm(@ModelAttribute Appointment a)
	{
		adservice.addApp(a);
		return "Index";
	}
	
	@GetMapping("/adminlogin")
	public String adminlogin()
	{
		return "AdminLogin.html";
	}
	
	@GetMapping("/adminconfirm")
	public String adminconfirm(Model m)
	{
		List<Appointment> adm=adservice.getAllapp();
		m.addAttribute("appts", adm);
		return "AdminConfirm.html";
	}
	
	@GetMapping("/deleteapp/{username}")
	public String deleteapp(@PathVariable String username,HttpSession session)
	{
		aservice.deleteApp(username);
		//session.setAttribute("msg", "deleted successfully");
		return "redirect:/adminconfirm";
	}
}
