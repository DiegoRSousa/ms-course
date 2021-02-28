package com.diego.hroauth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.hroauth.feignclients.UserFeignClient;
import com.diego.hroauth.model.User;

@Service
public class UserService {

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
}
