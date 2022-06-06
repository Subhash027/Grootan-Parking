package com.parkingmanagementsystem.demo.controller;


import com.parkingmanagementsystem.demo.model.Registration;
import com.parkingmanagementsystem.demo.model.entity.User;
import com.parkingmanagementsystem.demo.service.userservice.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	private UserService userService;

	public RegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}

	@ModelAttribute("user")
	public Registration user() {
		return new Registration();
	}

	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") Registration registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}

}
