package com.diego.hroauth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.diego.hroauth.feignclients.UserFeignClient;
import com.diego.hroauth.model.User;

@Service
public class UserService implements UserDetailsService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserFeignClient userFeignClient;
		
	public User findByEmail(String email) {
		var user = userFeignClient.findByEmail(email).getBody();
		if(user == null) {
			logger.error("Email not found!");
			throw new IllegalArgumentException("Email not found!");
		}
		logger.info("Email found");	
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		var user = userFeignClient.findByEmail(username).getBody();
		if(user == null) {
			logger.error("Email not found!");
			throw new UsernameNotFoundException("Email not found!");
		}
		logger.info("Email found");	
		return user;
	}
}
