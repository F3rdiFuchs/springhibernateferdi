package com.model.File;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.model.Note.Note;

@Entity
@Table(name="FILE")
public class File {
	@Id
    @GeneratedValue
    @Column(name="filid")
	private Integer filid;
	
	@ManyToOne
	@JoinColumn(name="note")
	private Note note;
	
	@Lob
	@Column(name="file")
	private byte[] file;

	public Integer getFilid() {
		return filid;
	}

	public void setFilid(Integer filid) {
		this.filid = filid;
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
