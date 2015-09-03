package com.model.Message;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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

}
/*m LEFT JOIN FETCH g.user*/