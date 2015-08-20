package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class UserDAOImpl implements UserDAO {
	private SessionFactory m_sessionFactory;
	
	public void setSessionFactory(SessionFactory _session)
	{
		this.m_sessionFactory = _session;
	}
	

	public void save(User _user)
	{
		
	}
	
	@SuppressWarnings("unchecked")
	public List<User> list()
	{
		Session session = this.m_sessionFactory.openSession();
		List<User> personList = session.createQuery("from user").list();
		session.close();
		return null;
	}

}
