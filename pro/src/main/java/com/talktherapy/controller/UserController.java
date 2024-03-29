package com.talktherapy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talktherapy.model.Appointment;
import com.talktherapy.model.Counsellor;
import com.talktherapy.model.User;
import com.talktherapy.repository.CounsellorRepository;
import com.talktherapy.repository.UserRepository;
import com.talktherapy.service.AppointmentService;
import com.talktherapy.service.UserServiceImp;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserRepository user1;
	@Autowired
	private UserServiceImp service;
	@Autowired
	private AppointmentService aservice;
	@Autowired
	private CounsellorRepository counsellorRepository;
	
	
	@PostMapping("/userlogin")
	public String userlogin(@ModelAttribute User u,Model model)
	{
		String m=u.getEmail();
		String p=u.getPassword();
		
		User user=user1.findByEmail(u.getEmail());
		//Appointment ap=aservice.findByUsername()
		System.out.println(user);
		if(p.equals(user.getPassword()))
		{
			model.addAttribute("info", user);
			return "UserDashBoard.html";
		}
		else
		{
			return "UserLogin.html";
		}
	}
	
	@PostMapping("/appfilled")
	public String appofilled(@ModelAttribute Appointment a)
	{
		System.out.println(a);
		aservice.addApp(a);
		
		return "Index.html";
	}
	
	@GetMapping("/user")
	public String userDashBoard()
	{
		return "UserDashBoard.html";
	}
	
	@GetMapping("/index")
	public String demo1()
	{
		return "Index.html";
	}
	@GetMapping("/help")
	public String help()
	{
		return "Help.html";
	}
	@GetMapping("/self")
	public String self()
	{
		return "SelfAssessment.html";
	}
	@GetMapping("/login")
	public String login()
	{
		return "UserLogin.html";
	}

	@GetMapping("/about")
	public String about()
	{
		return "About.html";
	}
	@GetMapping("/userbooking")
	public String userbooking(Model model)
	{
		List<Counsellor> list = counsellorRepository.findAll();
		model.addAttribute("list", list);
		return "UserBooking.html";
	}
	@GetMapping("/adminappconfirm")
	public String adminappconfirm()
	{
		return "AdminAppConfirm.html";
	}
	@GetMapping("/register")
	public String addUser(Model model) {
			//th object= user
		model.addAttribute("user",new User());
		return "UserRegistration.html";
		
	}
	@PostMapping("/addUser")
	public String processForm(User user,Model model) {
		user1.save(user);
		System.out.println(user.getUsername()+" "+user.getPassword()+" "+user.getEmail()+" "+user.getAddress()+" "+user.getMobile()+" "+user.getGender());
		return "redirect:/login";
	}
	@GetMapping("/userlist")
	public String userlist(Model model)
	{
		List<User>user=service.getAllUsers();
		model.addAttribute("user",user);
		return "UserList.html";
	}
	@GetMapping("/deleteuser/{id}")
	public String deleteuser(@PathVariable long id,HttpSession session)
	{
		service.deleteUser(id);
		//session.setAttribute("msg", "deleted successfully");
		return "redirect:/userlist";
	}
	@GetMapping("/edituser/{id}")
	public String edituser(@PathVariable long id,Model model)
	{
		User user=service.getUserById(id);
		model.addAttribute("user", user);
		return "UserProfileEdit.html";
	}
	@PostMapping("/updateuser")
	public String updateuser(@ModelAttribute User user,HttpSession session)
	{
		service.updateUser(user);
		//session.setAttribute("msg", "employee updated successfully");
		return "redirect:/userlist";
	}
	
	@GetMapping("/userappointment/{email}")
	public String userappointment(@PathVariable String email,Model model)
	{
		List<Appointment> a=aservice.getUserByEmail(email);
		model.addAttribute("appt", a);
		return "UserAppointment.html";
	}
	
}
