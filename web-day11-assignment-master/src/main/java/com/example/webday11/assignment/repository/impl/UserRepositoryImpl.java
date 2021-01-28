package com.example.webday11.assignment.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.webday11.assignment.entity.User;
import com.example.webday11.assignment.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public UserRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(User u) {
		Session session = sessionFactory.getCurrentSession();
		session.save(u);
	}

}
