package application.service.impl;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;

import application.constant.Constant;
import application.entity.JavaIOFile;
import application.service.IFileService;

public class FileServiceImpl implements IFileService {
	
	@SuppressWarnings("unchecked")
	public List<JavaIOFile> getAllFiles() {
		WebClient client = WebClient.create(Constant.WEB_SERVICE_URL).path(Constant.GET_FILES)
				.accept(MediaType.APPLICATION_XML);
		return 	(List<JavaIOFile>) client.getCollection(JavaIOFile.class);
	}

	public boolean createFile(String path) {
		WebClient client = WebClient.create(Constant.WEB_SERVICE_URL).path(Constant.CREATE_FILE+path)
				.accept(MediaType.APPLICATION_XML);
		client.get();
		return true;
	}
	

}
