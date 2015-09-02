package com.model.Guarantor;

import java.util.List;

import org.hibernate.SessionFactory;

public class GuarantorDAOImpl implements GuarantorDAO {
	private SessionFactory sessionFactory;
	
	public GuarantorDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public List<Guarantor> listGuarantor() {
		// TODO Auto-generated method stub
		return null;
	}
}
