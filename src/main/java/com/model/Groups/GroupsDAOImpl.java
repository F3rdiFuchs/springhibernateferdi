package com.model.Groups;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GroupsDAOImpl implements GroupsDAO {
	
	private SessionFactory m_sessionFactory;
	
	public GroupsDAOImpl(SessionFactory _sessionFactory)
	{
		this.m_sessionFactory = _sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Groups> listGroups()
	{
		List groupList = new ArrayList();
		Session session = this.m_sessionFactory.openSession();
		session.beginTransaction();
			/*
			Criteria cr = session.createCriteria(Groups.class);
			groupList = cr.list();
			for(Groups user : (List<Groups>)groupList)
			{
				user.getUser().toArray();
			}
			*/
		groupList = session.createQuery("SELECT DISTINCT g FROM Groups g LEFT JOIN FETCH g.user").list();
			
		session.getTransaction().commit();
		session.close();
		
		return groupList;
	}
	
	public void addGroup(Groups _userGroup){
	}
	
	public void updateGroup(Groups _group) {
	}
	
	public void removeGroup(Integer _groupid) {	
	}
}
