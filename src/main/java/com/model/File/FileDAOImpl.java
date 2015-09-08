package com.model.File;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Note.Note;

public class FileDAOImpl implements FileDAO{
	private SessionFactory sessionFactory;
	
	public FileDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<File> listFilesByUser(Integer noteId) {
		List<File> fileList = new ArrayList<File>();
		Note note = new Note();
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx2 = session.beginTransaction();
		
		
		note = (Note)session.get(Note.class, noteId);
		
		fileList = session.createQuery("FROM File WHERE note = :note")
				.setEntity("note", note)
				.list();;
		
				tx2.commit();
				session.close();
		
		return fileList;
	}
	
	@Transactional
	public void addFile(File file) {
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx2 = session.beginTransaction();
		session.persist(file);
		tx2.commit();
		session.close();
	}
}
