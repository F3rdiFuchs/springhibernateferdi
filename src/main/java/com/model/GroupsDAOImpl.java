package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GroupsDAOImpl implements GroupsDAO {
	
	private SessionFactory m_sessionFactory;
	
	public GroupsDAOImpl(SessionFactory _sessionFactory)
	{
		this.m_sessionFactory = _sessionFactory;
	}
	public void addGroup(Groups _userGroup)
	{
		Session session = this.m_sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(_userGroup);
        tx.commit();
        session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Groups> listGroups()
	{
		Session session = this.m_sessionFactory.openSession();
		session.beginTransaction();
		
		List<Groups> groupList = session.createQuery("FROM Groups").list();
		session.getTransaction().commit();
		session.close();
		return groupList;
	}
	public void updateGroup(Groups _group) {
		Session session = this.m_sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(_group);
		tx.commit();
		session.close();
		
	}
	public void removeGroup(int _groupid) {
		Session session = this.m_sessionFactory.openSession();
		session.beginTransaction();
		Groups group = (Groups) session.load(Groups.class, new Integer(_groupid));
		if(null != group){
            session.delete(group);
        }
		session.getTransaction().commit();
		session.close();
	}
	public List<User> listUserInGroup(int _userid) {
		Session session = this.m_sessionFactory.openSession();
		session.beginTransaction();
		List<User> userInGroupList = session.createQuery("From User Where Id = :_userid ").list();
		session.getTransaction().commit();
		session.close();
		return userInGroupList;
	}
}
