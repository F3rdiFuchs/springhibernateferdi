package com.service.FileService;

import java.util.List;

import com.model.File.File;

public interface FileService {
	public List <File> listFilesByUser(Integer noteId);
	public void addFile(File file);
}
