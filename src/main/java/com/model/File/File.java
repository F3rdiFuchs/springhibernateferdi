package com.model.File;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
	
	@Column(name="fileName")
	private String fileName;
	
	@Column(name="fileSize")
	private Long fileSize;
	
    @OneToOne(cascade={CascadeType.REMOVE,CascadeType.PERSIST})
    @PrimaryKeyJoinColumn
    private Data data;

	public Integer getFileId() {
		return fileId;
	}

	public void setFileid(Integer fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
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
