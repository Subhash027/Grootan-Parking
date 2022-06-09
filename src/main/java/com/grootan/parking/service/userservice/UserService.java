package com.grootan.parking.service.userservice;

import com.grootan.parking.model.Registration;
import com.grootan.parking.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService
{
	User save(Registration user);
	User findByUsername(String username);
}
