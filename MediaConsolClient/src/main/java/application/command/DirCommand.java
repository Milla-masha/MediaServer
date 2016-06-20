package application.command;


import java.util.List;

import application.entity.JavaIOFile;
import application.service.Factory;

public class DirCommand implements Command {

    public void printHelp() {
        System.out.println(getDescription());
    }

    public boolean execute(Context context, String... args) {
        if (args == null && context.getDirectory().isEmpty()) {
            printDir();
        }
        else if(args == null && !context.getDirectory().isEmpty()) {
        	 printDirPath(context.toString());}
        else {
        	if(!args[0].equals(".."))
        	
        	{
        		context.addAllDirectory(args[0]);
        		printDirPath(context.toString());
        	}else if(context.getDirectory().size()>0){
        	 context.deleteLastDirectory();
        	 printDirPath(context.toString());}
        	else System.out.println("You are in the root folder!");
        }
        return true;
    }

    public String getName() {
        return "DIR";
    }

    private void printDir() {	
    	 System.out.println("Directory content are");
    	 List<JavaIOFile> list=Factory.getInstance().getEmployeeDAO().getAllFiles();
       	 if(list==null||list.isEmpty())
       	 {
       		System.out.println("0 files and 0 dirs.");
       	 }
       	 else{
       		 for (JavaIOFile f : list) {
            	System.out.println(f.getName());
            		
            }
       	 }
        }
    
    private void printDirPath(String path) {	
   	 System.out.println("Directory content are");
   	 List<JavaIOFile> list=Factory.getInstance().getEmployeeDAO().getAllFilesPath(path);
   	 if(list==null||list.isEmpty())
   	 {
   		System.out.println("0 files and 0 dirs.");
   	 }
   	 else{
           for (JavaIOFile f : list) {
           	System.out.println(f.getName());
          }
         }
       }

	public String getDescription() {
        return "Prints directory content";
    }
}