package application.command;

class ExitCommand implements Command {
    public boolean execute(Context context, String... args) {
        System.out.println("Finishing command processor... done.");
        return false;
    }

    public void printHelp() {
        System.out.println(getDescription());
    }

    public String getName() {
        return "EXIT";
    }

    public String getDescription() {
        return "Exits from command processor";
    }
}

