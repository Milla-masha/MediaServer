package application.command;



import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.TreeMap;
import application.constant.Constant;


public class CommandProcessor {

	private Map<String, Command> commands;
	 
    private String consoleEncoding;

	private Scanner scanner;
	

	public Map<String, Command> getCommands() {
		return commands;
	}


	public CommandProcessor(String consoleEncoding) {
        commands = new TreeMap<String, Command>();
        Command cmd = new HelpCommand(commands);
        commands.put(cmd.getName(), cmd);
        cmd = new DirCommand();
        commands.put(cmd.getName(), cmd);
        cmd = new ExitCommand();
        commands.put(cmd.getName(), cmd);
        cmd=new CreateFileCommand();
        commands.put(cmd.getName(), cmd);
        cmd=new DeleteFileCommand();
        commands.put(cmd.getName(), cmd);
        cmd=new MoveFileCommand();
        commands.put(cmd.getName(), cmd);
        cmd=new DownloadFileCommand();
        commands.put(cmd.getName(), cmd);
        cmd=new UploadFileCommand();
        commands.put(cmd.getName(), cmd);
        cmd=new LikedCommand();
        commands.put(cmd.getName(), cmd);
        this.consoleEncoding = consoleEncoding;
    }
 
    public void execute() {
    	Context c = Context.getInstance();
        boolean result = true;
        scanner = new Scanner(System.in, consoleEncoding);
        do {
            System.out.print("> "+c.toDir()+" ");
            String fullCommand = scanner.nextLine();
            ParsedCommand pc = new ParsedCommand(fullCommand);
            if (pc.command == null || "".equals(pc.command)) {
                continue;
            }
            Command cmd = commands.get(pc.command.toUpperCase());
            if (cmd == null) {
                System.out.println(Constant.MSG_COMMAND_NOT_FOUND);
                continue;
            }
            result = cmd.execute(c, pc.args);
        } while (result);
    }
 
	public static void main(String[] args) throws IOException {
	
		 Properties prop = System.getProperties();
	        ProcessBuilder pb = null;
	        if ("Linux".equals(prop.getProperty("os.name"))) {
	            pb = new ProcessBuilder("xterm");
	        } else {
	            pb = new ProcessBuilder("cmd");
	        }
	        pb.start();
	        
		 CommandProcessor cp = new CommandProcessor("Cp1251");
	     cp.execute();
		
	}

	
}
