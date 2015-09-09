package com.model.File;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.model.Data.Data;
import com.model.Note.Note;

@Entity
@Table(name="file")
public class File {
	@Id
    @GeneratedValue
    @Column(name="fileid")
	private Integer fileId;
	
	@ManyToOne
	@JoinColumn(name="noteid")
	private Note note;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="dataid")
    private Data data;
	
	@Column(name="filename")
	private String fileName;
	
	@Column(name="filesize")
	private Long fileSize;

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
	
	@Override
	public String toString()
	{
		return this.fileName;
	}
}