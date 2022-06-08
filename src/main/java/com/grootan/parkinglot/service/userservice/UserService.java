package com.grootan.parkinglot.service.userservice;

import com.grootan.parkinglot.model.Registration;
import com.grootan.parkinglot.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService
{
	User save(Registration user);
	User findByUsername(String username);
}
