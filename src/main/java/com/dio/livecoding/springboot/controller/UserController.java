package com.dio.livecoding.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.livecoding.springboot.model.UserModel;
import com.dio.livecoding.springboot.services.UserService;

@RestController
@RequestMapping("/vi/user")
public class UserController {

	private final UserService userService = new UserService();
	@GetMapping
	public ResponseEntity<Iterable<UserModel>>getUsers(){
		return ResponseEntity.ok(userService.getUsers());
	}
}
