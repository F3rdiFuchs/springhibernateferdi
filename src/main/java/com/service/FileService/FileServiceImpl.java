package com.service.FileService;

import java.util.List;

import com.model.File.File;
import com.model.File.FileDAO;

public class FileServiceImpl implements FileService{
	private FileDAO fileDAO;
	
	public FileDAO getFileDAO() {
		return fileDAO;
	}

	public void setFileDAO(FileDAO fileDAO) {
		this.fileDAO = fileDAO;
	}

	public List<File> listFilesByUser(Integer noteId) {
		return this.fileDAO.listFilesByUser(noteId);
	}

	public void addFile(File file) {
		this.fileDAO.addFile(file);
	}

}
