package com.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.model.Groups.Groups;
import com.model.Message.Message;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
	private SessionFactory m_sessionFactory;
	private static final int DEFAULT_GROUPID_USER = 25;
	private static final int DEFAULT_MESSAGE_USER = 1;
	
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
		Message message;
		List messageList = new ArrayList();
		User user = (User)session.get(User.class, DEFAULT_MESSAGE_USER);
		
		messageList = session.createQuery("FROM Message m JOIN FETCH m.fromUser JOIN FETCH m.toUser WHERE toUser = :userId").list();

		for(int index=0; index < messageList.size();index++)
		{
			message = (Message) messageList.get(index);
			message.setFromUser(user);
			session.save(message);
			/*
			 * if(index != 0 && index % BATCH_SIZE == 0)
             * session.flush();
			 * 
			 */
		}

		session.delete(user);
		session.getTransaction().commit();
		
		session.close();
	}
}
