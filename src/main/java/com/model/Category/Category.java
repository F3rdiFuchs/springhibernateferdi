package com.model.Category;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.model.Note.Note;
import Enum.ECategory;

@Entity
@Table(name="category")
public class Category {
	@Id
	@Column(name="categoryid")
	@Enumerated(EnumType.STRING)
	private ECategory categoryId;
	
	@Column(name="description")
	private String description;
	
	@ManyToMany(mappedBy = "category")
	private List<Note> note;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ECategory getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(ECategory categoryId) {
		this.categoryId = categoryId;
	}

	public List<Note> getNote() {
		return note;
	}

	public void setNote(List<Note> note) {
		this.note = note;
	}
	
	@Override
	public String toString()
	{
		switch(categoryId)
		{
		case animals:
			return"animals";
		case important:
			return "important";
		case other:
			return "other";
		case sports:
			return "sports";
		case technique:
			return "technique";
		case todo:
			return "todo";
		default:
			return null;
		}
	}
}
