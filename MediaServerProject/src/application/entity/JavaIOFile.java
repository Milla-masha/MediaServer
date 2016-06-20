package application.entity;


import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class JavaIOFile {

	public JavaIOFile() {
	}
	public JavaIOFile(String name, boolean isFile) {
		this.name = name;
		this.isFile = isFile;
	}
	public JavaIOFile(String path) {
		this.path = path;
	}
	 
	private String name;
	 
	private boolean isFile;
	
	private String path;
	
	private Long length;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setFile(String isFile) {
		this.isFile =Boolean.getBoolean(isFile);
	}
	public boolean getIsFile() {
		return isFile;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Long getLength() {
		return length;
	}
	public void setLength(String string) {
		this.length =Long.getLong(string);
	}
	public void setLength(long length2) {
		this.length=length2;
		
	}
	public void setFile(boolean file) {
		this.isFile=file;	
	}
	
}
