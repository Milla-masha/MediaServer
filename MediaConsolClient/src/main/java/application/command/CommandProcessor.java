package application.command;


import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import application.constant.Constant;
import application.entity.JavaIOFile;

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
        this.consoleEncoding = consoleEncoding;
    }
 
    public void execute() {
        Context c = new Context();
        boolean result = true;
        scanner = new Scanner(System.in, consoleEncoding);
        do {
            System.out.print("> ");
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
 
	public static void main(String[] args) {
	
		 CommandProcessor cp = new CommandProcessor("Cp1251");
	     cp.execute();
		
	}

	public void printAll(List<JavaIOFile> files)
	{
		System.out.println("Directory include");
		if(files.isEmpty())
			System.out.print(" 0 files and 0 directories.");
		else{
		for(JavaIOFile file:files)
		{
			if(file.isFile())
				System.out.println("File"+file.getName());
			else
				System.out.println("Directory"+file.getName());
		}
		}
	}
}
