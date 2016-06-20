package application.command;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import application.service.Factory;
import application.service.IFileService;
import application.service.impl.FileServiceImpl;

public class MoveFileCommand implements Command{

	
	public boolean execute(Context context, String... args) {
		  if (args.length!=2) {
	            System.out.println("Please, input from file and where you want to move it!");
	        } else {
	        	//String from = new String(), where=new String();
	        	Context from=new Context();
	        	Context where=new Context();
	        	from.addAllDirectory(args[0]);
	        	where.addAllDirectory(args[1]);
	        	Factory.getInstance().getEmployeeDAO().moveFile(from.tofile(),where.toString()+from.getNameFile());
	        }
	        return true;
	}

	public void printHelp() {
		 System.out.println(getDescription());
		
	}

	public String getName() {
		 return "MOVE";
	}

	public String getDescription() {
		 return "Moves the file (from where).";
	}

}
