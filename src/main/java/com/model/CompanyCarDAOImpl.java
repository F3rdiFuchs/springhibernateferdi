package com.model;

import java.util.List;

import org.hibernate.SessionFactory;

public class CompanyCarDAOImpl implements CompanyCarDAO {
	private SessionFactory m_sessionFactory;
	
	public CompanyCarDAOImpl(SessionFactory _sessionFactory)
	{
		this.m_sessionFactory = _sessionFactory;
	}
	
	public List<CompanyCar> listCompanyCar() {
		// TODO Auto-generated method stub
		return null;
	}
}
