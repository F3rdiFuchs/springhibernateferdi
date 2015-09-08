package com.model.Note;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name="note")
public class Note {
	@Id
    @GeneratedValue
    @Column(name="noteid")
	private Integer noteId;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
	
	@NotNull
	@Size(min=5, max=200, message="Must be between 5 and 200 letters")
	@Column(name="note")
	private String note;
	
	@NotNull
	@Column(name="date")
	private String date;
	
	@OneToMany(mappedBy = "note",cascade={CascadeType.REMOVE,CascadeType.PERSIST})
	private List<File> file = new ArrayList<File>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="notecategory", joinColumns = @JoinColumn(name = "noteid"), inverseJoinColumns = @JoinColumn(name = "categoryid"))
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


	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}
	
}
