package application.command;

public class DeleteFileCommand implements Command {

	public boolean execute(Context context, String... args) {
		// TODO Auto-generated method stub
		return false;
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
