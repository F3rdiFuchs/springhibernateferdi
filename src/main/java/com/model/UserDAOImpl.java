package com.model;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class UserDAOImpl implements UserDAO {
	private SessionFactory m_sessionFactory;
	
	public UserDAOImpl(SessionFactory _sessionFactory)
	{
		this.m_sessionFactory = _sessionFactory;
	}
	
	public void save(User _user)
	{
		Session session = this.m_sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(_user);
        tx.commit();
        session.close();
	}
	
	@SuppressWarnings("unchecked") 
	public List<User> list()
	{
		Session session = this.m_sessionFactory.openSession();
		session.beginTransaction();
		
		List<User> personList = (List<User>) session.createQuery("FROM User").list();
		session.getTransaction().commit();
		
		
		session.close();
		return personList;
	}

}
