package application.command;

import java.util.ArrayList;
import java.util.List;

public class Context {
	
	 private static Context instance = null;
	 private List<String> directory;
	 private String nameFile;
	 
	 public Context(){
		 directory=new ArrayList<String>();
		 nameFile=new String();
	 }
	public List<String> getDirectory() {
		return directory;
	}
	public void setDirectory(List<String> directory) {
		this.directory = directory;
	}

	public List<String> addDirectory(String temp) {
		 directory.add(temp);
		 return directory;
	}
	
	
	public List<String> deleteLastDirectory() {
		 directory.remove(directory.size()-1);
		 return directory;
	}

	public static synchronized Context getInstance() {
			if (instance == null) {
				instance = new Context();
			}
			return instance;
		}
	
	
	@Override
	public String toString() {
		String dir=new String();
	     for(String s:directory)
	     {
	    	 dir+=s+"&";
	     }
		 return dir;
	}
	
	public String tofile() {
		String dir=new String();
	     for(String s:directory)
	     {
	    	 dir+=s+"&";
	     }
	     if (nameFile!=null)
	    	 dir+=nameFile;
		 return dir;
	}
	

	public String getNameFile() {
		return nameFile;
	}
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	public String toDir() {
		String dir=new String();
	     for(String s:directory)
	     {
	    	 dir+=s+"/";
	     }
		 return dir;
	}
	
	
	 public List<String> addAllDirectory(String path)
	    {
	    	List<String> paths=new ArrayList<String>();
	    	String parts[] = path.split("/");
	    	for (String str:parts) 
	    		if(str.contains("."))
	    			nameFile=str;
	    		else paths.add(str);
	    	 directory.addAll(paths);
	           return paths;
	        }       
	    

}
