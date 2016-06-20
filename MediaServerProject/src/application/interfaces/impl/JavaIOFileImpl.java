package application.interfaces.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;
import application.constant.Constant;
import application.entity.JavaIOFile;
import application.interfaces.IJavaIOFileService;
import application.service.CreateFile;

@Component("JavaIOFileService")
public class JavaIOFileImpl implements IJavaIOFileService {
	File dir;
    File[] files;
    List<JavaIOFile> iofiles;
	
	public JavaIOFileImpl()
	{	dir= new File(Constant.ROOT_PATH);
	    files=new File[0];
	    iofiles=new ArrayList<JavaIOFile>();
	}

	
	@Override
	public List<JavaIOFile> getAllJavaIOFile(){
		dir= new File(Constant.ROOT_PATH);
		if(!dir.isDirectory())
			{
			dir.mkdirs();
			return null;
			}
		iofiles=new ArrayList<JavaIOFile>();
		for(File file:dir.listFiles())
		{
			iofiles.add(
					new JavaIOFile(file.getName(),file.isFile()
							));
		}
		return iofiles;
	}

	@Override
	public List<JavaIOFile> getAllJavaIOFileByPath(String path) {
         CreateFile create=new CreateFile(path);
		dir= create.getFile();
		if(!dir.isDirectory())
			{
			dir.mkdirs();
			return null;
			}
		iofiles=new ArrayList<JavaIOFile>();
		for(File file:dir.listFiles())
		{
			iofiles.add(
					new JavaIOFile(file.getName(),file.isFile()
							));
		}
		return iofiles;
	}


	@Override
	public Response createFile(String path) {
		 CreateFile create=new CreateFile(path);
			dir= create.getFile();
		try {
			dir.createNewFile();
			 ResponseBuilder response = Response.status(Status.OK);
	          return response.build();
		} catch (IOException e) {
			 ResponseBuilder response = Response.status(Status.BAD_REQUEST);
	          return response.build();}
		
		}
		
	


	@Override
	public Response deleteFile(String path) {
		 CreateFile create=new CreateFile(path);
		 dir= create.getFile();
		 if(dir.exists())
		 {	delete(dir);
		  ResponseBuilder response = Response.status(Status.OK);
          return response.build();}
		 else 
	     {ResponseBuilder response = Response.status(Status.BAD_REQUEST);
         return response.build();}

	}
	
	  public void delete(File file)
	  {
	    if(!file.exists())
	      return;
	    if(file.isDirectory())
	    {
	      for(File f : file.listFiles())
	        delete(f);
	      file.delete();
	    }
	    else
	    {
	      file.delete();
	    }
	  }


	@Override
	public Response moveFile(String from,String where) throws IOException {
		
		 CreateFile create=new CreateFile(where);
		 File oldFile= create.getFile();
         create=new CreateFile(from);
         File newFile= create.getFile();
         System.out.println(oldFile.toPath());
 		System.out.println(newFile.toPath());
         if(oldFile.exists()){
		Files.copy(oldFile.toPath(), newFile.toPath());		
		oldFile.delete();
		 ResponseBuilder response = Response.status(Status.OK);
         return response.build();}
		 else 
	     {ResponseBuilder response = Response.status(Status.BAD_REQUEST);
         return response.build();}
         
	}
	

}
