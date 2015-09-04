package com.model.Note;

import java.util.List;


public interface NoteDAO {
	public List <Note> listNotes();
	public void addNote(Note newNote);
}
