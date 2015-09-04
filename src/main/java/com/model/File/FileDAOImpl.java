package com.model.File;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Note.Note;

public class FileDAOImpl implements FileDAO{
	private SessionFactory m_sessionFactory;
	
	public FileDAOImpl(SessionFactory _sessionFactory)
	{
		this.m_sessionFactory = _sessionFactory;
	}
	
	public List<File> listFilesByUser(Integer noteId) {
		List fileList = new ArrayList();
		Note note = new Note();
		Session session = this.m_sessionFactory.openSession();
		session.beginTransaction();
		
		
		note = (Note)session.get(Note.class, noteId);
		
		fileList = session.createQuery("FROM File WHERE note = :note")
				.setEntity("note", note)
				.list();;
		
		session.getTransaction().commit();
		session.close();
		
		return fileList;
	}
}
