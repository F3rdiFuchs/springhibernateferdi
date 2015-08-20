package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GroupsDAOImpl implements GroupsDAO {
	
	private SessionFactory m_sessionFactory;
	
	public GroupsDAOImpl(SessionFactory _sessionFactory)
	{
		this.m_sessionFactory = _sessionFactory;
	}
	public void save(Groups _userGroup)
	{
		Session session = this.m_sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(_userGroup);
        tx.commit();
        session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Groups> list()
	{
		Session session = this.m_sessionFactory.openSession();
		session.beginTransaction();
		
		List<Groups> groupList = (List<Groups>) session.createQuery("FROM Groups").list();
		session.getTransaction().commit();
		session.close();
		return groupList;
	}
}
