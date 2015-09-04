package com.service.Note;

import java.util.List;

import com.model.Note.Note;
import com.model.Note.NoteDAO;

public class NoteServiceImpl implements NoteService {
	private NoteDAO  noteDAO;

	public List<Note> listNotes() {
		return this.noteDAO.listNotes();
	}

	public NoteDAO getNoteDAO() {
		return noteDAO;
	}

	public void setNoteDAO(NoteDAO noteDAO) {
		this.noteDAO = noteDAO;
	}

	public void addNote(Note newNote) {
		this.noteDAO.addNote(newNote);
	}
	

}
