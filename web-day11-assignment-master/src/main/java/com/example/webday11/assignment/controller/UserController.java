package com.example.webday11.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webday11.assignment.dto.UserDTO;
import com.example.webday11.assignment.entity.User;
import com.example.webday11.assignment.service.RoleService;
import com.example.webday11.assignment.service.UserService;
import com.example.webday11.assignment.tranform.UserTranform;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private RoleService roleService;

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public User insertUser(@RequestBody UserDTO body) {
		UserTranform userTranform = new UserTranform(roleService);
		userService.insert(userTranform.apply(body));
		return userTranform.apply(body);
	}
}
