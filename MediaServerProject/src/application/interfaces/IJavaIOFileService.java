package application.interfaces;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;

import application.entity.JavaIOFile;




public interface IJavaIOFileService {
	
	@GET
	@Description(value="Resource", target = DocTarget.RESOURCE)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN,MediaType.APPLICATION_XML})
	@Path("/getall")
	public List<JavaIOFile> getAllJavaIOFile();
	
	@GET
	@Description(value="Resource", target = DocTarget.RESOURCE)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN,MediaType.APPLICATION_XML})
	@Path("/getall/{path}")
	public List<JavaIOFile> getAllJavaIOFileByPath(@PathParam("path") String path);
	
	@GET
	@Description(value="Resource", target = DocTarget.RESOURCE)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN,MediaType.APPLICATION_XML})
	@Path("/createFile/{path}")
	public Response createFile(@PathParam("path") String path);
	
	@GET
	@Description(value="Resource", target = DocTarget.RESOURCE)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN,MediaType.APPLICATION_XML})
	@Path("/deleteFile/{path}")
	public Response deleteFile(@PathParam("path") String path);
	
	@POST
	@Description(value="Resource", target = DocTarget.RESOURCE)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN,MediaType.APPLICATION_XML})
	@Path("/moveFile/{where}")
	public Response moveFile(@PathParam("where") String where,String from)throws IOException;
}
