package application.command;

import java.util.List;

import application.constant.Constant;
import application.entity.JavaIOFile;
import application.service.Factory;

public class LikedCommand implements Command {

    public void printHelp() {
        System.out.println(getDescription());
    }

    public boolean execute(Context context, String... args) {
    	if(args!=null)
        if (args[0].equals("get")) {
            printLiked();
        }
        else if(args[0].equals("add")) {
        	Context newCont= new Context();
        	newCont.addAllDirectory(args[1]);
        	if(Factory.getInstance().getEmployeeDAO().addLikedFile(newCont.tofile()))
        		System.out.println(Constant.MSG_COMMAND_COMPLETE);
        	
        	else System.out.println(Constant.MSG_NO);
        }
        else if(args[0].equals("delete")) {
        	Context newCont= new Context();
        	newCont.addAllDirectory(args[1]);
        	if(Factory.getInstance().getEmployeeDAO().deleteLikedFile(newCont.tofile()))
        		System.out.println(Constant.MSG_COMMAND_COMPLETE);
        	
        	else System.out.println(Constant.MSG_NO);
        }

        return true;
    }

    public String getName() {
        return "LIKED";
    }

    private void printLiked() {	
    	 System.out.println("Liket content are");
    	 List<JavaIOFile> list=Factory.getInstance().getEmployeeDAO().getLikedFiles();
       	 if(list==null||list.isEmpty())
       	 {
       		System.out.println("0 files.");
       	 }
       	 else{
       		 for (JavaIOFile f : list) {
                System.out.println("Name file :"+f.getName()+",size "+f.getLength()+"path "+f.getPath()+".");
            }
       	 }
        }
    

	public String getDescription() {
        return "Prints liked files";
	}
	}
