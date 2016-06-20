package application.command;

public class Context {
	
	 private static Context instance = null;
	 private String directory=null;
	 
	 public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public static synchronized Context getInstance() {
			if (instance == null) {
				instance = new Context();
			}
			return instance;
		}
	
	public void addDirectory(String path)
	{
		directory+="/"+path;
		}

}
