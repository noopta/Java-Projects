package adventure;

import java.util.ArrayList;
/* TODO add a static data structure or another enum class
that lists all the valid commands.  Then add methods for validating
commands 

You may add other methods to this class if you wish*/

public class Command implements java.io.Serializable {
    private String actionWord; // done
    private String noun; // done
    private ArrayList<String> verbCommands; // done
    private ArrayList<String> nounCommands; // done
    private ArrayList<Item> allItems;

    /**
     * Create a command object with default values. both instance variables are set
     * to null
     * 
     */
    public Command() throws InvalidCommandException {
        this(null, null);
        setVerbCommands();
        setNounCommands();
        allItems = new ArrayList<Item>();
    }

    /**
     * overriding the toString method
     */
    @Override
    public String toString() {
        return String.format("Action word: " + actionWord);
    }

    /**
     * Create a command object given only an action. this.noun is set to null
     *
     * @param command The first word of the command.
     * 
     */

    public Command(String command) throws InvalidCommandException {

        // TODO validate the action word here and throw an exception if it isn't
        // a single-word action

        this(command, null);
        setVerbCommands();
        setNounCommands();
        allItems = new ArrayList<Item>();
        int counter = 0;

        for (String userCmd : verbCommands) {
            if (userCmd.equals(command)) {
                counter++;
            }
        }

        if (counter == 0) {
            throw new InvalidCommandException();
        }
    }

    /**
     * Create a command object given both an action and a noun
     *
     * @param command The first word of the command.
     * @param what    The second word of the command.
     */
    public Command(String command, String what) throws InvalidCommandException {
        // TODO validate the command here and ensure that the noun provided
        // is a legitimate second word for the command
        // throw an exception if not
        setVerbCommands();
        setNounCommands();
        allItems = null;
        this.actionWord = command;
        this.noun = what;
    }

    /**
     * setting the list of verbs that are valid
     */
    public void setVerbCommands() {
        verbCommands = new ArrayList<String>();
        verbCommands.add("look");
        verbCommands.add("quit");
        verbCommands.add("go");
        verbCommands.add("save");
        verbCommands.add("inventory");

    }

    /**
     * setting the list of nouns that are valid
     */
    public void setNounCommands() {
        nounCommands = new ArrayList<String>();
        nounCommands.add("up");
        nounCommands.add("down");
        nounCommands.add("W");
        nounCommands.add("N");
        nounCommands.add("S");
        nounCommands.add("E");

    }

    /**
     * setter for the action member variable
     * 
     * @param inputAction
     */
    public void setActionWord(String inputAction) {
        actionWord = inputAction;
    }

    /**
     * setter for the noun member variable
     * 
     * @param inputNoun
     */
    public void setNoun(String inputNoun) {
        noun = inputNoun;
    }

    /**
     * Return the command word (the first word) of this command. If the command was
     * not understood, the result is null.
     *
     * @return The command word.
     */
    public String getActionWord() {
        return actionWord;
    }

    /**
     * @return The second word of this command. Returns null if there was no second
     *         word.
     */
    public String getNoun() {

        return noun;
    }

    /**
     * @return true if the command has a second word.
     */

    public boolean hasSecondWord() {
        return (noun != null);
    }

    /**
     * stores all of the game items in an array of Items in the Command object
     * 
     * @param inputItems all of the game items
     */
    public void setAllItems(ArrayList<Item> inputItems) {
        if (inputItems == null) {
            return;
        } else {
            allItems = inputItems;
        }
    }

    /**
     * prints all items was used mainly just for testing to see if setAllItems
     * worked which it did
     */
    public void printItems() {
        if (allItems == null) {
            return;
        } else {
            System.out.println("Printing all items from command");
            for (Item iterateItem : allItems) {

                System.out.println(iterateItem.getName());
            }
            System.out.println("Done");
        }
    }

    /**
     * 
     * @return returns all the verbs for a single command entry
     */
    public ArrayList<String> getVerbs() {
        return verbCommands;
    }

}
