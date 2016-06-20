package application.command;

public interface Command {
	
	boolean execute(Context context, String... args);
	 
     void printHelp();

     String getName();

     String getDescription();
}
