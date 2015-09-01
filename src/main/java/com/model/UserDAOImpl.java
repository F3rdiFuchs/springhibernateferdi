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
	private static final int DEFAULT_GROUPID_USER = 25;
	
	public UserDAOImpl(SessionFactory _sessionFactory)
	{
		this.m_sessionFactory = _sessionFactory;
	}
	
	@SuppressWarnings("unchecked") 
	public List<User> listUser(){
		List userList = new ArrayList();
		Session session = this.m_sessionFactory.openSession();
		
		session.beginTransaction();
		Criteria cr = session.createCriteria(User.class);
		userList = cr.list();
		session.getTransaction().commit();
		
		session.close();
		
		return userList;
	}
	
	public void addUser(User user){
		user.encryptPasswd();
		Session session = this.m_sessionFactory.openSession();
		
		session.beginTransaction();
			
		Groups group = (Groups)session.get(Groups.class, DEFAULT_GROUPID_USER);
		user.setGroups(group);
			
		session.persist(user);
		session.getTransaction().commit();
		
		session.close();
	}
	
	public void removeUser(Integer userId) {
		Session session = this.m_sessionFactory.openSession();
		session.beginTransaction();
		
		User user = (User)session.get(User.class, userId);
		session.delete(user);
		session.getTransaction().commit();
		
		session.close();
	}
}
