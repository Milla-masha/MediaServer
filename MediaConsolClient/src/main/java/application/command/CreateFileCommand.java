package application.command;

import application.service.IFileService;
import application.service.impl.FileServiceImpl;

public class CreateFileCommand implements Command{

	public boolean execute(Context context, String... args) {
		  if (args == null) {
	            System.out.println("Please, input name file!");
	        } else {
	        	IFileService service= new FileServiceImpl();
	        	service.createFile(args[0]);
	        }
	        return true;
	}

	public void printHelp() {
		 System.out.println(getDescription());
		
	}

	public String getName() {
		 return "CREATE";
	}

	public String getDescription() {
		 return "Create file or directory";
	}

}
