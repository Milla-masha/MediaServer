package application.interfaces.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.activation.DataHandler;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.springframework.stereotype.Component;

import application.constant.Constant;
import application.interfaces.IDownloadFileService;
import application.service.CreateFile;

@Component("DownloadFileService")
public class LoadsFileImpl implements IDownloadFileService {

	File file;
	public LoadsFileImpl()
	{	file= new File(Constant.ROOT_PATH);
	}

        @Override
	    public Response getFileInTextFormat(String fileName) 
	    {
	        //System.out.println("File requested is : " + fileName);
	        if(fileName == null || fileName.isEmpty())
	        {
	            ResponseBuilder response = Response.status(Status.BAD_REQUEST);
	            return response.build();
	        }
	        CreateFile create=new CreateFile(fileName);
			file= create.getFile();
	         
	        ResponseBuilder response = Response.ok((Object) file);
	        response.header("Content-Disposition", "attachment; filename="+ file.getName());
	        return response.build();
	    }

        
        @Override
        public Response uploadTextFile(List<Attachment> attachments) {
     
            for (Attachment attachment : attachments) {
                DataHandler dataHandler = attachment.getDataHandler();
                try{
                   String fileName=attachment.getContentId();
                    InputStream inputStream = dataHandler.getInputStream();
                    writeToFileServer(inputStream, fileName);
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
                finally {
                    // release resources, if any
                }
            }
            return Response.ok("upload success").build();
        }
     
        /**
         *
         * @param inputStream
         * @param fileName
         */
        private void writeToFileServer(InputStream inputStream, String fileName) {
     
            OutputStream outputStream = null;
            try {
            	  CreateFile create=new CreateFile(fileName);
          		File file= create.getFile();
                outputStream = new FileOutputStream(file);
                int read = 0;
                byte[] bytes = new byte[1024];
                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                outputStream.flush();
                outputStream.close();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
            finally{
                //release resource, if any
            }
        }

}
