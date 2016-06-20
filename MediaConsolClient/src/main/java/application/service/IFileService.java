package application.service;

import java.io.File;
import java.util.List;

import application.entity.JavaIOFile;

public interface IFileService {

	public List<JavaIOFile> getAllFiles();
	public List<JavaIOFile> getAllFilesPath(String path);
	public boolean createFile(String path);
	public boolean deleteFile(String path);
	public boolean moveFile(String from, String where);
	public boolean downloadFile(String path);
	public boolean postFile(File file,String path);
	public List<JavaIOFile> getLikedFiles();
	public boolean addLikedFile(String path);
	public boolean deleteLikedFile(String path);
}
