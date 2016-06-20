package application.service;

import java.util.List;

import application.entity.JavaIOFile;

public interface IFileService {

	public List<JavaIOFile> getAllFiles();
	public boolean createFile(String path);
}
