package com.parkingmanagementsystem.demo.service.userservice;

import com.parkingmanagementsystem.demo.model.Registration;
import com.parkingmanagementsystem.demo.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface UserService extends UserDetailsService {
	User save(Registration user);

	User findByUsername(String username);
}
