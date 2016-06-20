package application.service;

import java.io.File;

import application.constant.Constant;

public class CreateFile {

	File file=null;
	
	public CreateFile( String path)
	{
		path=path.replace("&","/");
		file= new File (Constant.ROOT_PATH+"/"+path);
	}
	
	public File getFile()
	{
		return file;
	}
}
