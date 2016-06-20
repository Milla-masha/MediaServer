package application.interfaces;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;
import org.springframework.web.bind.annotation.RequestParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;

@Path("/DownloadFile")
public interface IDownloadFileService {


	    @GET
	    @Path("/download/{fileName}")
	    @Produces("text/plain")
	    public Response getFileInTextFormat(@PathParam("fileName") String fileName);
	    
	    @POST
	    @Path("/upload/text")
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	    public Response uploadTextFile(List<Attachment> attachments);
	  //  public Response setFileInTextFormat(@RequestParam("fileName") String fileName, File file);


}
