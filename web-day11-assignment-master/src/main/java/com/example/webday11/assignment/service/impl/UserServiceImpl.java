package com.example.webday11.assignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webday11.assignment.entity.User;
import com.example.webday11.assignment.repository.UserRepository;
import com.example.webday11.assignment.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void insert(User u) {
		userRepository.insert(u);
	}
}
