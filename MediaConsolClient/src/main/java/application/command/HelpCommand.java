package application.command;

import java.util.Map;

import application.constant.Constant;

public class HelpCommand implements Command {
	
	private Map<String, Command> commands;

	public HelpCommand(Map<String, Command> commands)
	{
	this.commands=commands;	
	}
	
	  public boolean execute(Context context, String... args) {
          if (args==null) {
              System.out.println("Avaliable commands:\n" + Constant.MSG_DELIM);
              for (Command cmd : commands.values()) {
                  System.out.println(cmd.getName() + ": " + cmd.getDescription());
              }
              System.out.println(Constant.MSG_DELIM);
          } else {
              for (String cmd : args) {
                  System.out.println("Help for command " + cmd + ":\n" + Constant.MSG_DELIM);
                  Command command = commands.get(cmd.toUpperCase());
                  if (command == null) {
                      System.out.println(Constant.MSG_COMMAND_NOT_FOUND);
                  } else {
                      command.printHelp();
                  }
                  System.out.println(Constant.MSG_DELIM);
              }
          }
          return true;
	  }
	  
      public void printHelp() {
          System.out.println(getDescription());
      }

      public String getName() {
          return "HELP";
      }

      public String getDescription() {
          return "Prints list of available commands";
      }
  }