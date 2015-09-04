package com.model.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.model.Data.Data;
import com.model.Note.Note;

@Entity
@Table(name="FILE")
public class File {
	@Id
    @GeneratedValue
    @Column(name="fileId")
	private Integer fileId;
	
	@ManyToOne
	@JoinColumn(name="noteId")
	private Note note;
	
    @OneToOne(fetch = FetchType.LAZY, mappedBy="file")
	private Data data;

	public Integer getFileId() {
		return fileId;
	}

	public void setFileid(Integer fileId) {
		this.fileId = fileId;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	
}
