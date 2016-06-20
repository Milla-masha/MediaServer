package application.interfaces.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import application.entity.JavaIOFile;
import application.interfaces.ILikedFileService;
import application.service.AddXML;
import application.service.CreateFile;
import application.service.DeleteXML;
import application.service.XMLParser;

@Component("LikedFileService")
public class LikedFileImpl implements ILikedFileService{

	@Override
	public List<JavaIOFile> getAllJavaIOFile() {
		XMLParser parser;
		try {
			parser = new XMLParser();
			List<JavaIOFile> files=parser.getList();
			return files;
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Response addLikedFile(String path) {
		   CreateFile create=new CreateFile(path);
		   File dir= create.getFile();
			if(!dir.exists())
			{
				System.out.println("eahr");
				ResponseBuilder response = Response.status(Status.BAD_REQUEST);
	            return response.build();
			}
			else
			{
				JavaIOFile file=new JavaIOFile();
				file.setName(dir.getName());
				file.setLength(dir.length());
				file.setFile(dir.isFile());
				file.setPath(path);
				AddXML xml=new AddXML(file);
				ResponseBuilder response = Response.status(Status.OK);
	            return response.build();
			}
	}

	@Override
	public Response deleteLikedFile(String path) {
		 CreateFile create=new CreateFile(path);
		   File dir= create.getFile();
			if(!dir.exists())
			{
				ResponseBuilder response = Response.status(Status.BAD_REQUEST);
	            return response.build();
			}
			else
			{
				JavaIOFile file=new JavaIOFile();
				file.setName(dir.getName());
				file.setLength(dir.length());
				file.setFile(dir.isFile());
				file.setPath(path);
				DeleteXML xml=new DeleteXML(file);
				ResponseBuilder response = Response.status(Status.OK);
	            return response.build();
			}
	}

}
