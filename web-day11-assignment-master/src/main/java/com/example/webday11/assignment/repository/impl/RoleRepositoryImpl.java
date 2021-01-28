package com.example.webday11.assignment.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.webday11.assignment.entity.Role;
import com.example.webday11.assignment.repository.RoleRepository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public RoleRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Role findByRoleName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query<Role> query = session.createQuery("select r from Role r where r.name = '" + name + "'", Role.class);
		List<Role> resultList = query.getResultList();
		if (resultList != null && resultList.size() > 0) {
			return resultList.get(0);
		}
		throw new RuntimeException("More than one Role returned");
	}
}
