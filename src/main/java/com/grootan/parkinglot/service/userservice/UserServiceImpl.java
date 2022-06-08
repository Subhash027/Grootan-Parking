package com.grootan.parkinglot.service.userservice;

import com.grootan.parkinglot.model.Registration;
import com.grootan.parkinglot.model.entity.Role;
import com.grootan.parkinglot.model.entity.User;
import com.grootan.parkinglot.repository.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService
{
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserServiceImpl(UserRepository userRepository)
	{
		super();
		this.userRepository=userRepository;
	}

	@Override
	public User save(Registration user)
	{
		User user1=new User(user.getUserName(),user.getEmail(),bCryptPasswordEncoder.encode(user.getPassword()), Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user1);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUserName(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	public String currentUser()
	{
		Authentication authentication=getCurrentUser();
		return  authentication.getName();
	}

	public Authentication getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication;
	}

}