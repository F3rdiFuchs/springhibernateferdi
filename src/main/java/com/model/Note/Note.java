package com.model.Note;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.model.Category.Category;
import com.model.File.File;
import com.model.User.User;



@Entity
@Table(name="NOTE")
public class Note {
	@Id
    @GeneratedValue
    @Column(name="noteId")
	private Integer noteId;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@NotNull
	@Size(min=5, max=200, message="Must be between 5 and 200 letters")
	@Column(name="note")
	private String note;
	
	@NotNull
	@Column(name="date")
	private String date;
	
	@OneToMany(mappedBy = "note")
	private List<File> files;
	
	@ManyToMany(mappedBy = "notes")
	private List<Category> category;

	public Integer getNoteId() {
		return noteId;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}
}
