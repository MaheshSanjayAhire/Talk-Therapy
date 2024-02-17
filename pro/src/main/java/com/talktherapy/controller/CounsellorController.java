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
import com.talktherapy.model.Counsellor;
import com.talktherapy.repository.CounsellorRepository;
import com.talktherapy.service.AdminService;
import com.talktherapy.service.CounsellorServiceImp;

import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellorController {
	@Autowired
	private CounsellorRepository counsellor1;
	@Autowired
	private CounsellorServiceImp service;
	@Autowired
	private AdminService adservice;
	@GetMapping("/counsellorregister")
	public String addUser(Model model) {
			//th object= user
		model.addAttribute("counsellor",new Counsellor());
		return "CounsellorRegistration.html";
		
	}
	@PostMapping("/addCounsellor")
	public String processForm(Counsellor counsellor,Model model) {
		counsellor1.save(counsellor);
		System.out.println(counsellor.getFullname());
		return "redirect:/counsellorregister";
	}
	@GetMapping("/counsellorlist")
	public String counsellorlist(Model model)
	{
		List<Counsellor>counsellor=service.getAllCounsellors();
		model.addAttribute("counsellor",counsellor);
		return "CounsellorList.html";
	}
	@GetMapping("/deletecounsellor/{id}")
	public String deletecounsellor(@PathVariable long id,HttpSession session)
	{
		service.deleteCounsellor(id);
		//session.setAttribute("msg", "deleted successfully");
		return "redirect:/counsellorlist";
	}
	@GetMapping("/editcounsellor/{id}")
	public String editcounsellor(@PathVariable long id,Model model)
	{
		Counsellor counsellor=service.getCounsellorById(id);
		model.addAttribute("counsellor", counsellor);
		return "CounsellorProfileEdit.html";
	}
	@PostMapping("/updatecounsellor")
	public String updateuser(@ModelAttribute Counsellor counsellor,HttpSession session)
	{
		service.updateCounsellor(counsellor);
		//session.setAttribute("msg", "employee updated successfully");
		return "redirect:/counsellorlist";
	}
	
	@GetMapping("/counsellor")
	public String showall(Model m)
	{
		List<Appointment> adm=adservice.getAllapp();
		m.addAttribute("appts", adm);
		return "CounsellorDashBoard";
	}
	
	@GetMapping("/counsellorlogin")
	public String counsellorlogin()
	{
		return "CounsellorLogin.html";
	}
	
	@PostMapping("counsellorslogin")
	public String counsellorslogin(@ModelAttribute Counsellor c,Model m) 
	{
		String p=c.getPassword();
		Counsellor counsellor=counsellor1.findByEmail(c.getEmail());
		if(p.equals(counsellor.getPassword()))
		{
			return "redirect:/counsellor";
		}
		else 
		{
			return "CounsellorLogin.html";
		}
		
	}
}
