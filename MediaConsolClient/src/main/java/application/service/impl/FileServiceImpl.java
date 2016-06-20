package application.service.impl;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.attachment.ContentDisposition;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.web.bind.annotation.ResponseStatus;

import application.command.Context;
import application.constant.Constant;
import application.entity.JavaIOFile;
import application.service.IFileService;


public class FileServiceImpl implements IFileService {
	
	public List<JavaIOFile> getAllFiles() {
		WebClient client = WebClient.create(Constant.WEB_SERVICE_URL).path(Constant.GET_FILES)
				.accept(MediaType.APPLICATION_XML);
		return 	(List<JavaIOFile>) client.getCollection(JavaIOFile.class);
	}
	
	public List<JavaIOFile> getAllFilesPath(String path) {
		WebClient client = WebClient.create(Constant.WEB_SERVICE_URL).path(Constant.GET_FILES_PATH+path)
				.accept(MediaType.APPLICATION_XML);
		return 	(List<JavaIOFile>) client.getCollection(JavaIOFile.class);
	}

	public boolean createFile(String path) {
		WebClient client = WebClient.create(Constant.WEB_SERVICE_URL).path(Constant.CREATE_FILE+path)
				.accept(MediaType.APPLICATION_XML);
		if (client.get().getStatus()==200)
			return true;
			else return false;
	}
	public boolean deleteFile(String path) {
		WebClient client = WebClient.create(Constant.WEB_SERVICE_URL).path(Constant.DELETE_FILE+path)
				.accept(MediaType.APPLICATION_XML);
		if (client.get().getStatus()==200)
			return true;
			else return false;
	}
	
	public boolean moveFile(String from, String where) {
		WebClient client = WebClient.create(Constant.WEB_SERVICE_URL).path(Constant.MOVE_FILE+"/"+where)
				.accept(MediaType.APPLICATION_XML);
		client.post(from, String.class);
		if (client.get().getStatus()==200)
			return true;
			else return false;
	}

	public boolean downloadFile(String path) {
		WebClient client = WebClient.create(Constant.WEB_SERVICE_URL).path(Constant.DOWNLOAD_FILE+path)
				.accept("text/plain");
		File file;
		file=client.get(File.class);
        Context dir=new Context();
        dir.addAllDirectory(path);
		File save=new File("C:/Users/Aleks69/Downloads/"+dir.getNameFile());
		try {
			Files.copy(file.toPath(), save.toPath());
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			/e.printStackTrace();
			return false;
		}
	}

	public boolean postFile(File file, String path) {	
		WebClient client = WebClient.create(Constant.WEB_SERVICE_URL).path(Constant.POST_FILE)
				.type(MediaType.MULTIPART_FORM_DATA) ;
		Attachment att = new Attachment(path, "attachment;filename="+file.getName(),file);
		client.post(new MultipartBody(att));
		
		if (client.get().getStatus()==200)
			return true;
			else return false;
	}

	public List<JavaIOFile> getLikedFiles() {
		WebClient client = WebClient.create(Constant.WEB_SERVICE_URL).path(Constant.GET_LIKED_FILE)
				.accept(MediaType.APPLICATION_XML);
		return 	(List<JavaIOFile>) client.getCollection(JavaIOFile.class);
	}
	
	public boolean addLikedFile(String path) {
		WebClient client = WebClient.create(Constant.WEB_SERVICE_URL).path(Constant.ADD_LIKED_FILE+path)
				.accept(MediaType.APPLICATION_XML);
		if (client.get().getStatus()==200)
		return true;
		else return false;
	}

	public boolean deleteLikedFile(String path) {
		WebClient client = WebClient.create(Constant.WEB_SERVICE_URL).path(Constant.DELETE_LIKED_FILE+path)
				.accept(MediaType.APPLICATION_XML);
		if (client.get().getStatus()==200)
		return true;
		else return false;
	}
}
