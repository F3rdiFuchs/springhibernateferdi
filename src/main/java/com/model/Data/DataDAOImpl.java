package com.model.Data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DataDAOImpl implements DataDAO{
	private SessionFactory sessionFactory;
		
	public DataDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addData(Data data) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(data);
		session.getTransaction().commit();
		session.close();
	}
}
