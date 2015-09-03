package com.model.Message;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Groups.Groups;
import com.model.User.User;

public class MessageDAOImpl implements MessageDAO{
private SessionFactory sessionFactory;
	
	public MessageDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	public List<Message> listMessages() {
		List messageList = new ArrayList();
		
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		messageList = session.createQuery("FROM Message m JOIN FETCH m.fromUser JOIN FETCH m.toUser").list();
			
		session.getTransaction().commit();
		session.close();
		
		return messageList;
	}
	
	public void sendMessage(Message message) {
		Session session = this.sessionFactory.openSession();
		
		session.beginTransaction();		
		session.persist(message);
		session.getTransaction().commit();
		session.close();
	}
	public void deleteMessage(Integer messageId) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		Message message = (Message)session.get(Message.class, messageId);
		
		session.delete(message);
		session.getTransaction().commit();
		
		session.close();
		
	}

}
/*m LEFT JOIN FETCH g.user*/