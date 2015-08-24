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
	
	public void addUser(User _user)
	{
		Session session = this.m_sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(_user);
        tx.commit();
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
	
	public void updateUser(User _user) {
		Session session = this.m_sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(_user);
		tx.commit();
		session.close();
		
	}

	public void removeUser(int _userId) {
		Session session = this.m_sessionFactory.openSession();
		session.beginTransaction();
		User user = (User) session.load(User.class, new Integer(_userId));
		if(null != user){
            session.delete(user);
        }
		session.getTransaction().commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<User> listUserById(int _id) {
		Session session = this.m_sessionFactory.openSession();
		session.beginTransaction();
		
		List<User> userList = (List<User>) session.createQuery("FROM User WHERE groups_groupid = :_id").list();
		session.getTransaction().commit();
		
		
		session.close();
		return userList;
	}


}
