package application.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;

import com.sun.research.ws.wadl.Request;

import application.entity.JavaIOFile;

@Path("/LikedFile")
public interface ILikedFileService {

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
	@Path("/add/{path}")
	public Response addLikedFile(@PathParam("path") String path);
	
	@GET
	@Description(value="Resource", target = DocTarget.RESOURCE)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN,MediaType.APPLICATION_XML})
	@Path("/delete/{path}")
	public Response deleteLikedFile(@PathParam("path") String path);
}
