package com.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TasksDAOImpl implements TasksDAO {

	private SessionFactory sessionFactory;
	
	public TasksDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public void addTasks(Tasks tasks) {
		tasks.setStatus(false);
		Session session = this.sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.merge(tasks);
        
		tx.commit();
        session.close();
		
	}

	public List<Tasks> listTasks() {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		List<Tasks> tasksList = session.createQuery("SELECT DISTINCT t FROM Tasks t JOIN FETCH t.user").list();
		
		session.getTransaction().commit();
		session.close();
		return tasksList;
	}
}
