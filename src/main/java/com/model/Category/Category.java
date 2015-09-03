package com.model.Category;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.model.Note.Note;

@Entity
@Table(name="CATEGORY")
public class Category {
	@Id
	private String categoryid;
	
	@ManyToMany
	@JoinTable(name="NOTECATEGORY", joinColumns = @JoinColumn(name = "categoryId"),inverseJoinColumns = @JoinColumn(name = "noteId"))
	private List<Note> notes;

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
}
