package com.model.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.model.File.File;

@Entity
@Table(name="DATA")
public class Data {
	
	@Id
	@Column(name="fileid")
	private int fildid;
	
	@Lob
	@Column(name="data")
	private byte[] data;
	
	@OneToOne
    @PrimaryKeyJoinColumn
	private File file;
}
