package com.model.Note;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Category.Category;

public class NoteDAOImpl implements NoteDAO{
	private SessionFactory sessionFactory;
	
	public NoteDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Note> listNotes() {
		List <Note>noteList = new ArrayList<Note>();
		
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		noteList	= session.createQuery("FROM Note n LEFT JOIN FETCH n.user").list();
		
		session.getTransaction().commit();
		session.close();
		
		return noteList;
	}
	
	@Transactional
	public void addNote(Note newNote) {	
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx2 = session.beginTransaction();
		
		session.persist(newNote);
		
		tx2.commit();
		session.close();
	}

}
