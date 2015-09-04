package com.model.File;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
	
	@Lob 
	@Basic(fetch=FetchType.LAZY)
	@Column(name="file")
	private byte[] file;

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

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}
}
