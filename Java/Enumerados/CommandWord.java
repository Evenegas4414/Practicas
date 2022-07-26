package Clases.Enumerados;

public enum CommandWord {

    GO("go"), LOOK("look"), TAKE("take"),
    HELP("help"), QUIT("quit");

    private String commandString;

    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }

    public String toString ()
    {
        return "Name: " + this.name() + ". commandString: " + commandString;
    }
}