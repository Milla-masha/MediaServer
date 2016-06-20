package application.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class JavaIOFile {


	public JavaIOFile() {
	}
	public JavaIOFile(String name, boolean isFile) {
		this.name = name;
		this.isFile = isFile;
	}
	 
	private String name;
	 
	private boolean isFile;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isFile() {
		return isFile;
	}
	public void setFile(boolean isFile) {
		this.isFile = isFile;
	}
	
}
