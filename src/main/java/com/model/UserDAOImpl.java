package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.List;

public class UserDAOImpl implements UserDAO {
	private SessionFactory m_sessionFactory;
	private static final int AUTO_GROUPID = 25;
	
	public UserDAOImpl(SessionFactory _sessionFactory)
	{
		this.m_sessionFactory = _sessionFactory;
	}
	
	public void addUser(User user)
	{
		user.encryptPasswd();
		Session session = this.m_sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked") 
	public List<User> listUser()
	{
		Session session = this.m_sessionFactory.openSession();
		session.beginTransaction();
		
		List<User> userList = (List<User>) session.createQuery("FROM User").list();
		session.getTransaction().commit();
		
		
		session.close();
		return userList;
	}
	
	public void updateUser(User user) {
		Session session = this.m_sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		session.close();
		
	}

	public void removeUser(String uId) {
		Session session = this.m_sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("DELETE FROM User WHERE userid = :uId");
		query.setString("uId", uId);
		query.executeUpdate();
		
		session.getTransaction().commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<User> listUserById(int id) {
		Session session = this.m_sessionFactory.openSession();
		session.beginTransaction();
		
		List<User> userList = (List<User>) session.createQuery("FROM User WHERE groups_groupid = :id").list();
		session.getTransaction().commit();
			
		session.close();
		return userList;
	}

	

}
