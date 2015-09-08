package com.model.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.model.File.File;

@Entity
@Table(name="data")
public class Data {
	
	@Id
	@Column(name="fileid")
	private int fildId;
	
	@Lob
	@Column(name="data")
	private byte[] data;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="data")
	private File file;

	public int getFildId() {
		return fildId;
	}

	public void setFildid(int fildid) {
		this.fildId = fildid;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}