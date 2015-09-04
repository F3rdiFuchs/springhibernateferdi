package com.model.Category;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.model.Note.Note;

import Enum.ECategory;

@Entity
@Table(name="CATEGORY")
public class Category {
	@Id
	@Column(name="categoryId")
	@Enumerated(EnumType.STRING)
	private ECategory categoryId;
	
	@ManyToMany
	@JoinTable(name="NOTECATEGORY", joinColumns = @JoinColumn(name = "categoryId"),inverseJoinColumns = @JoinColumn(name = "noteId"))
	private List<Note> notes;

	public ECategory getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(ECategory categoryId) {
		this.categoryId = categoryId;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
}
