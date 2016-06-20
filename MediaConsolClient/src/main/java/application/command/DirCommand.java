package application.command;

import application.entity.JavaIOFile;
import application.service.IFileService;
import application.service.impl.FileServiceImpl;

public class DirCommand implements Command {
	 
    public void printHelp() {
        System.out.println(getDescription());
    }

    public boolean execute(Context context, String... args) {
        if (args == null) {
            printDir();
        } else {
            // print specified directory content
            // todo
        }
        return true;
    }

    public String getName() {
        return "DIR";
    }

    private void printDir() {
    	IFileService service= new FileServiceImpl();
    	System.out.println("Directory content are");
            for (JavaIOFile f : service.getAllFiles()) {
            	if(f.isFile()){
                System.out.println(f.getName()+" (file)");
                }
            	else System.out.println(f.getName()+" (directory)");
            		
            }
        }

    public String getDescription() {
        return "Prints directory content";
    }
}