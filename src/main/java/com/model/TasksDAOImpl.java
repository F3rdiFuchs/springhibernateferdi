package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TasksDAOImpl implements TasksDAO {

	private SessionFactory sessionFactory;
	
	public TasksDAOImpl(SessionFactory _sessionFactory)
	{
		this.sessionFactory = _sessionFactory;
	}
	
	public void save(Tasks _task) {
		Session session = this.sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.persist(_task);
        tx.commit();
        session.close();
		
	}

	public List<Tasks> listTasks() {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		List<Tasks> tasksList = session.createQuery("FROM Tasks").list();
		
		session.getTransaction().commit();
		session.close();
		return tasksList;
	}
	@SuppressWarnings("unchecked")
	public List<User> listUserInTask(int id) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		List<User> userInTaskList = session.createQuery("FROM User JOIN user_has_tasks ON user.userid = user_has_tasks.user_userid WHERE user_has_tasks.tasks_taskid= '" + id + "'").list();
		session.getTransaction().commit();
		session.close();
		return userInTaskList;
	}
}
