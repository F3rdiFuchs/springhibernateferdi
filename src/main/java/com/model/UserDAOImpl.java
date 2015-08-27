package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
	private SessionFactory m_sessionFactory;
	
	public UserDAOImpl(SessionFactory _sessionFactory)
	{
		this.m_sessionFactory = _sessionFactory;
	}
	
	
	@SuppressWarnings("unchecked") 
	public List<User> listUser()
	{
		List userList = new ArrayList();
		Session session = this.m_sessionFactory.openSession();
		try
		{
			session.beginTransaction();
			Criteria cr = session.createCriteria(User.class);
			userList = cr.list();
			session.getTransaction().commit();
		}

		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return userList;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> listUserByGroupId(int groupId) {
		List userList = new ArrayList();
		Session session = this.m_sessionFactory.openSession();
		try
		{
			session.beginTransaction();
			Criteria cr = session.createCriteria(User.class);
			cr.add(Restrictions.gt("groupid", groupId));
			userList = cr.list();
			session.getTransaction().commit();
		}

		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return userList;
	}
	
	public void addUser(User user)
	{
		user.encryptPasswd();
		Session session = this.m_sessionFactory.openSession();
		try
		{
			session.beginTransaction();
			session.persist(user);
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
	
	public void removeUser(Integer userId) {
		Session session = this.m_sessionFactory.openSession();
		session.beginTransaction();
		try
		{
			User user = (User)session.get(User.class, userId);
			session.delete(user);
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}


	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
