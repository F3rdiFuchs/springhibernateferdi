package com.model.File;

import java.util.List;

public interface FileDAO {
	public List <File> listFilesByUser(Integer noteId);
}
