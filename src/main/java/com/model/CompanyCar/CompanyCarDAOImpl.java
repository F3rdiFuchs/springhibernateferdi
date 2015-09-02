package com.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CompanyCarDAOImpl implements CompanyCarDAO {
	private SessionFactory m_sessionFactory;
	
	public CompanyCarDAOImpl(SessionFactory _sessionFactory)
	{
		this.m_sessionFactory = _sessionFactory;
	}
	
	public List<CompanyCar> listCompanyCar() {
		List companyCarList = new ArrayList();
		Session session = this.m_sessionFactory.openSession();
		
		
		session.beginTransaction();
		companyCarList = session.createQuery("SELECT DISTINCT g FROM CompanyCar g LEFT JOIN FETCH g.guarantor").list();
		session.getTransaction().commit();
		
		session.close();
		
		return companyCarList;
	}
}