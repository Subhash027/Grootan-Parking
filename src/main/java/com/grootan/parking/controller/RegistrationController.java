package com.grootan.parking.controller;


import com.grootan.parking.model.Registration;
import com.grootan.parking.service.userservice.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController
{
	private UserService userService;

	public RegistrationController(UserService userService)
	{
		super();
		this.userService = userService;
	}

	@ModelAttribute("user")
	public Registration user()
	{
		return new Registration();
	}

	@GetMapping
	public String showRegistrationForm()
	{
		return "registration";
	}
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") Registration registrationDto)
	{
		try
		{
			userService.save(registrationDto);
			return "redirect:/registration?success";
		}
		catch (DataIntegrityViolationException exceptionMessage)
		{
			return "redirect:/registration?error";
		}
	}
}
