package com.cognizant.authenticationservice.security;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.authenticationservice.models.AppUser;
import com.cognizant.authenticationservice.models.DefinedUserDetails;
import com.cognizant.authenticationservice.models.User;
import com.cognizant.authenticationservice.repository.UserRepository;

import lombok.Data;

@Service   
// It has to be annotated with @Service.
public class UserDetailsServiceImpl implements UserDetailsService  {
	
	@Autowired
	UserRepository userRepository;
	
	//@Autowired
	//private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<User> user = userRepository.findByUserName(userName);
		
		user.orElseThrow(()-> {throw new UsernameNotFoundException("No found "+userName);});
		return user.map(DefinedUserDetails::new).get();

	}	
}