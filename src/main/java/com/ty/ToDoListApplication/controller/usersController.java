package com.ty.ToDoListApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.ToDoListApplication.dto.UsersDto;
import com.ty.ToDoListApplication.model.UsersModel;
import com.ty.ToDoListApplication.service.UsersService;
import com.ty.ToDoListApplication.utils.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class usersController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UsersService usersService;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(UsersDto user) {
		try {
			usersService.registerUser(user);
			return ResponseEntity.ok("User account registerd");
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) {

		UsersModel usersModel = usersService.findByUsername(username);

		if (usersModel == null) {
			throw new RuntimeException("Invalid credentials: User not found");
		}

		String username1 = usersModel.getUsername();
		String password1 = usersModel.getPassword();

		// Compare hashed passwords instead of plain text
		if (username1.equals(username) && password1.equals(password)) {
			return jwtUtil.generateToken(username);
		} else {
			throw new RuntimeException("Invalid credentials: Password mismatch");
		}
	}

	public void getUserList() {

	}

}
