package com.example.webday11.assignment.tranform;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.webday11.assignment.dto.UserDTO;
import com.example.webday11.assignment.entity.Role;
import com.example.webday11.assignment.entity.User;
import com.example.webday11.assignment.service.RoleService;

import net.bytebuddy.implementation.bytecode.StackManipulation.Size;

@Component
public class UserTranform {

	private RoleService roleService;

	@Autowired
	public UserTranform(RoleService roles) {
		this.roleService = roles;
	}

	public User apply(UserDTO dto) {
		User user = new User();
		List<String> roles = dto.getRoles();
		Set<Role> rs = new HashSet<>();
		for (String r : roles) {
			if (roleService.findByRoleName(r) != null) {
				user.setFullname(dto.getFullname());
				user.setUsername(dto.getUsername());
				rs.add(roleService.findByRoleName(r));
			}
		}
		user.setRoles(rs);
		return user;
	}
}
