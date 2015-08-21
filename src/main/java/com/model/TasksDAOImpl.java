package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TasksDAOImpl implements TasksDAO {

	private SessionFactory m_sessionFactory;
	
	public TasksDAOImpl(SessionFactory _sessionFactory)
	{
		this.m_sessionFactory = _sessionFactory;
	}

	public void save(Tasks _task) {
		Session session = this.m_sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(_task);
        tx.commit();
        session.close();
		
	}

	public List<Tasks> list() {
		Session session = this.m_sessionFactory.openSession();
		session.beginTransaction();
		
		List<Tasks> taskList = session.createQuery("FROM Tasks").list();
		session.getTransaction().commit();
		session.close();
		return taskList;
	}

}
