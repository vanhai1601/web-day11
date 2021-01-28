package com.example.webday11.assignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webday11.assignment.entity.Role;
import com.example.webday11.assignment.repository.RoleRepository;
import com.example.webday11.assignment.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;

	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	@Transactional
	public Role findByRoleName(String name) {
		return roleRepository.findByRoleName(name);
	}

}
