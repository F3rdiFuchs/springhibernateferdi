package com.model.Category;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CategoryDAOImpl implements CategoryDAO {
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory _sessionFactory)
	{
		this.sessionFactory = _sessionFactory;
	}
	
	public List<Category> listCategory() {
		List categoryList = new ArrayList();
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		categoryList= session.createQuery("FROM Category").list();
		
		session.getTransaction().commit();
		session.close();
		return categoryList;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
