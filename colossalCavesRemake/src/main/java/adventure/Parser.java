package adventure;

import java.util.Scanner;

public class Parser implements java.io.Serializable {
    /**
     * contructor for the Parser class
     */
    private String allCommands;

    Parser() {
        allCommands = null;
    }

    /**
     * overriding the toString method
     */
    @Override
    public String toString() {
        return String.format("Parser Class");
    }

    /**
     * setter for the allCommands member variable
     * 
     * @param inputCommand input assigned to the member variable
     */
    public void setAllCommands(String inputCommand) {
        allCommands = inputCommand;
    }

    /**
     * 
     * @param userCommand the user entered command
     * @return returns a Command object intialized with just a verb or both verb and
     *         noun depending on input
     * @throws InvalidCommandException incase of an invalid command
     */
    public Command parseUserCommand(String userCommand) throws InvalidCommandException {
        // split the user input into verb and noun
        Scanner inSS = null;
        String testString = "split string";
        String verb = null;
        String noun = null;
        allCommands = userCommand;
        inSS = new Scanner(userCommand);

        verb = inSS.next();

        if (verb == null || verb.equals("")) {
            System.out.println("Throwing exception");
            throw new InvalidCommandException();
        }

        if (inSS.hasNext()) {
            noun = inSS.next();

            // if there are two words in the input
            Command twoCommands = new Command(verb, noun);
            return twoCommands;
        } else {

            // if there is one word in the userInput
            Command oneCommand = new Command(verb);
            return oneCommand;
        }
    }

    /**
     * 
     * @return returns all commands
     */
    public String allCommands() {
        System.out.println(allCommands);
        return allCommands;
    }
}
