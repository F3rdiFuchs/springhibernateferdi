package com.model.Note;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class NoteDAOImpl implements NoteDAO{
	private SessionFactory sessionFactory;
	
	public NoteDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Note> listNotes() {
		List noteList = new ArrayList();
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		noteList= session.createQuery("FROM Note n LEFT JOIN FETCH n.user").list();
		
		session.getTransaction().commit();
		session.close();
		return noteList;
	}

}
