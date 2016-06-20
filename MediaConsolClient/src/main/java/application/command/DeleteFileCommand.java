package application.command;

import application.service.Factory;

public class DeleteFileCommand implements Command {

	public boolean execute(Context context, String... args) {
		  if (args == null) {
	            System.out.println("Please, input name file!");
	        } else {
	        	context.addAllDirectory(args[0]);
	        	Factory.getInstance().getEmployeeDAO().deleteFile(context.tofile());
	        }
	        return true;
	}

	public void printHelp() {
		 System.out.println(getDescription());
		
	}

	public String getName() {
		 return "DELETE";
	}

	public String getDescription() {
		 return "Delete file or directory";
	}

}
