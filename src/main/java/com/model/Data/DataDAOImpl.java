package com.model.Data;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DataDAOImpl implements DataDAO{
	private SessionFactory sessionFactory;
		
	public DataDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void addData(Data data) {
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx2 = session.beginTransaction();
		session.save(data);
		tx2.commit();
		session.close();
	}
}
