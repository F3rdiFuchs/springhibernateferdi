package com.model;

import java.util.HashSet;

import org.hibernate.SessionFactory;

public class TaskDAOImpl implements TaskDAO {

	private SessionFactory m_sessionFactory;
	
	public TaskDAOImpl(SessionFactory _sessionFactory)
	{
		this.m_sessionFactory = _sessionFactory;
	}

	public void save(Task _task) {
		// TODO Auto-generated method stub
		
	}

	public HashSet<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
