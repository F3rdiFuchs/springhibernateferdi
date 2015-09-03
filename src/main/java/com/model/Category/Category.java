package com.model.Category;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	public enum ECategory{animals,important,other,sports,technique,todo}
	
	@Id
	@Column(name="categoryid")
	private ECategory categoryid;
	
	@ManyToMany
	@JoinTable(name="NOTECATEGORY", joinColumns = @JoinColumn(name = "categoryId"),inverseJoinColumns = @JoinColumn(name = "noteId"))
	private List<Note> notes;

	public ECategory getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(ECategory categoryid) {
		this.categoryid = categoryid;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
}
