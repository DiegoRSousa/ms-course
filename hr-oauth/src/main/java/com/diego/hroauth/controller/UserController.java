package com.diego.hroauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diego.hroauth.model.User;
import com.diego.hroauth.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
		
	@GetMapping("/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		var user = userService.findByEmail(email);
		return ResponseEntity.ok(user);
	}
}