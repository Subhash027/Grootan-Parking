package com.parkingmanagementsystem.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {


	@GetMapping("/")
	public String root()
	{
		return "index";
	}
	@GetMapping("/login")
	public String LoginPage()
	{
		return "login";
	}

}
