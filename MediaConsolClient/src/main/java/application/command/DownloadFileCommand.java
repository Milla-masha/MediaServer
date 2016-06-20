package application.command;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import application.service.Factory;
import application.service.IFileService;
import application.service.impl.FileServiceImpl;

public class DownloadFileCommand implements Command{

	
	public boolean execute(Context context, String... args) {
		  if (args == null) {
	            System.out.println("Please, input name file!");
	        } else {
	        	context.addAllDirectory(args[0]);
	        	Factory.getInstance().getEmployeeDAO().downloadFile(context.tofile());
	        }
	        return true;
	}

	public void printHelp() {
		 System.out.println(getDescription());
		
	}

	public String getName() {
		 return "DOWNLOAD";
	}

	public String getDescription() {
		 return "Download file";
	}

}
