package com.model;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserGroupDAOImpl implements UserGroupDAO {
	
	private SessionFactory m_sessionFactory;
	
	public UserGroupDAOImpl(SessionFactory _sessionFactory)
	{
		this.m_sessionFactory = _sessionFactory;
	}
	public void save(UserGroup _userGroup)
	{
		Session session = this.m_sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(_userGroup);
        tx.commit();
        session.close();
	}
	public HashSet<UserGroup> list()
	{
		return null;
	}
}
