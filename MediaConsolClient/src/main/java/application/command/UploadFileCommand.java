package application.command;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import application.service.Factory;
import application.service.IFileService;
import application.service.impl.FileServiceImpl;

public class UploadFileCommand implements Command{

	
	public boolean execute(Context context, String... args) {
		  if (args.length!=2) {
	            System.out.println("Please, input from file and where you want to move it!");
	        } else {
	        	//String from = new String(), where=new String();
	        	Context where=new Context();
	        	where.addAllDirectory(args[1]);
	        	File file=new File(args[0]);
	        	Factory.getInstance().getEmployeeDAO().postFile(file,where.toString()+file.getName());
	        }
	        return true;
	}

	public void printHelp() {
		 System.out.println(getDescription());
		
	}

	public String getName() {
		 return "POST";
	}

	public String getDescription() {
		 return "Post the file (from where).";
	}

}
