package com.example.webday11.assignment.repository;

import com.example.webday11.assignment.entity.Role;

public interface RoleRepository {

	Role findByRoleName(String name);
}
