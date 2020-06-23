package adventure;

import java.util.ArrayList;

public class Player implements java.io.Serializable {

    private String userName;
    private ArrayList<Item> userItems;
    private Room currentRoom;
    private String savedGameName;

    /**
     * below is a constructor that initializes all the fields of the Player class
     */
    Player() {
        userName = "User Name";
        userItems = new ArrayList<Item>();
        currentRoom = new Room();
        savedGameName = "Game Name";
    }

    /**
     * overriding the toString method
     */
    @Override
    public String toString() {
        return String.format("Player Room: " + currentRoom);
    }

    /**
     * 
     * 
     * @param inputName sets inputName as the value for the userName field
     */
    public void setUserName(String inputName) {
        userName = inputName;
    }

    /**
     * 
     * 
     * @param inputRoom sets the current Room field to the input Room
     */
    public void setCurrentRoom(Room inputRoom) {
        currentRoom = inputRoom;
    }

    /**
     * 
     * @param inputName sets param as the savedGameName variable
     */
    public void setSavedGameName(String inputName) {
        savedGameName = inputName;
    }

    /**
     * adds an item to the inventory
     * 
     * @param inputItem the item being added to the players inventory
     */
    public void setUserItems(Item inputItem) {
        userItems.add(inputItem);
    }

    /**
     * 
     * 
     * @return returns the userName
     */
    public String getName() {

        return userName;
    }

    /**
     * 
     * 
     * @return returns the array of items a user has
     */
    public ArrayList<Item> getInventory() {

        return userItems;
    }

    /**
     * 
     * 
     * @return returns the current room the player is in
     */
    public Room getCurrentRoom() {

        return currentRoom;
    }

    /**
     * 
     * @return returns the saved game name
     */
    public String getSaveGameName() {

        return savedGameName;
    }

}
