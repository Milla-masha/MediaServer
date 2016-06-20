package application.entity;

import java.util.List;

public class Folder extends JavaIOFile {
	
	private List<Files> listFile;
	private List<Folder> listFolder;
	
	public List<Files> getListFile() {
		return listFile;
	}
	public void setListFile(List<Files> listFile) {
		this.listFile = listFile;
	}
	public List<Folder> getListFolder() {
		return listFolder;
	}
	public void setListFolder(List<Folder> listFolder) {
		this.listFolder = listFolder;
	}
}
