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
	private SessionFactory sessionFactory;
	private static final int DEFAULT_GROUPID_USER = 25;
	private static final int DEFAULT_MESSAGE_USER = 1;
	
	public UserDAOImpl(SessionFactory _sessionFactory)
	{
		this.sessionFactory = _sessionFactory;
	}
	
	@SuppressWarnings("unchecked") 
	public List<User> listUser(){
		List userList = new ArrayList();
		Session session = this.sessionFactory.openSession();
		
		session.beginTransaction();
		Criteria cr = session.createCriteria(User.class);
		userList = cr.list();
		session.getTransaction().commit();
		
		session.close();
		
		return userList;
	}
	
	public void addUser(User user){
		user.encryptPasswd();
		Session session = this.sessionFactory.openSession();
		
		session.beginTransaction();
			
		Groups group = (Groups)session.get(Groups.class, DEFAULT_GROUPID_USER);
		user.setGroups(group);
			
		session.persist(user);
		session.getTransaction().commit();
		
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public void removeUser(Integer userId) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		List <Message> messageList = new ArrayList<Message>();
		User standartUser 	= (User)session.get(User.class, DEFAULT_MESSAGE_USER);
		User usertodelete 	= (User)session.get(User.class, userId);
		
		messageList = session.createQuery("FROM Message m JOIN FETCH m.fromUser JOIN FETCH m.toUser WHERE fromUser = :user")
				.setEntity("user", usertodelete)
				.list();

		
		for(Message fmessage : (List<Message>)messageList)
		{
			fmessage.setFromUser(standartUser);
			session.save(fmessage);
		}


		session.delete(usertodelete);// cascade-delete
		session.getTransaction().commit();
		
		session.close();
	}

	public boolean checkLogin(String userName, String passWord) {
		User user = new User();
		User tmp = new User();
		tmp.setPassWord(passWord);
		tmp.encryptPasswd();
		
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		user = (User) session.get(User.class, userName);
		if(!userName.equals("") && !passWord.equals(""))
		{
			if(user.getPassWord()== tmp.getPassWord())
			{
				return true;
			}
		}
		return false;
	}
}
