package adventure;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Adventure implements java.io.Serializable {

    /**
     *
     */
    // private static final long serialVersionUID = 1668185791920622435L;
    private final ArrayList<Room> allRooms;
    private final ArrayList<Item> allItems;
    private String currentRoomDescription;
    private Room currentRoom;
    private Player newPlayer;

    /**
     * constructor intializing the adventure object
     */
    public Adventure() {
        newPlayer = new Player();
        allRooms = new ArrayList<Room>();
        currentRoomDescription = null;
        allItems = new ArrayList<Item>();
        currentRoom = null;
    }

    /**
     * overriding the toString method
     */
    @Override
    public String toString() {
        return String.format("Current room in the adventure: " + currentRoom.getName());
    }

    /**
     * 
     * @param inputRoom room to be added to the total rooms array in the adventure
     */
    public void setAllRooms(final Room inputRoom) {
        allRooms.add(inputRoom);
    }

    /**
     * setting the newPlayer memeber variable
     * 
     * @param inputPlayer player variable to be used to set the newPlayer member
     *                    variable
     */
    public void setNewPlayer(Player inputPlayer) {
        newPlayer = inputPlayer;
    }

    /**
     * 
     * @param inputItem the item to be added to the total items array in the
     *                  adventure
     */
    public void setAllItems(final Item inputItem) {
        allItems.add(inputItem);
    }

    /**
     * 
     * @param inputDescription assigns the current room short description with the
     *                         input description
     */
    public void setCurrentRoomDescription(final String inputDescription) {
        currentRoomDescription = inputDescription;
    }

    /**
     * 
     * @param inputRoom room that will be assigned as the current player room
     */
    public void setCurrentRoom(final Room inputRoom) {
        currentRoom = inputRoom;
    }

    /**
     * 
     * @return lists all the rooms in the adventure and returns the array of all
     *         rooms
     */
    public ArrayList<Room> listAllRooms() {
        int i;
        for (i = 0; i < allRooms.size(); i++) {
            System.out.println(allRooms.get(i).getName());
        }
        return allRooms;
    }

    /**
     * 
     * @return prints all the items in the adventure and returns the array of all
     *         items
     */
    public ArrayList<Item> listAllItems() {
        int i;

        if (allItems == null) {
            System.out.println("No items in the room");
        }
        for (i = 0; i < allItems.size(); i++) {
            System.out.println(allItems.get(i).getName());
        }
        return allItems;
    }

    /**
     * 
     * @return returns the current rooms short description
     */
    public String getCurrentRoomDescription() {

        return currentRoom.getShortDescription();
    }

    /**
     * 
     * @return returns the current rooms long description
     */
    public String getCurrentLongDescription() {
        return currentRoom.getLongDescription();
    }

    /**
     * 
     * @return returns the current rooms id
     */
    public Long getCurrentId() {
        return currentRoom.getRoomId();
    }

    /**
     * 
     * @return returns the current rooms name
     */
    public String getCurrentName() {
        return currentRoom.getName();
    }

    /**
     * 
     * @return returns the current rooms loot id
     */
    public Long getCurrentLootId() {
        return currentRoom.getLootId();
    }

    /**
     * 
     * @return returns the total count of the total rooms array
     */
    public int roomCount() {
        return allRooms.size();
    }

    /**
     * 
     * @return returns the total count of the total items array
     */
    public int itemCount() {
        return allItems.size();
    }

    /**
     * 
     * @return returns the array of all items
     */
    public ArrayList<Item> getAllItems() {
        return allItems;
    }

    /**
     * 
     * @return returns the current room
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * 
     * @return returns the array of all the rooms in the adventure
     */
    public ArrayList<Room> getAllRooms() {
        return allRooms;
    }

    /**
     * 
     * @param toGo the command which has the direction to move the player
     */
    public void moveHero(Command toGo) {
        String inputDirection;
        Room roomConnected = new Room();
        int i;

        inputDirection = toGo.getNoun();
        roomConnected = getCurrentRoom().getConnectedRoom(inputDirection);

        if (roomConnected.getName() == null) {
            System.out.println("No room in that direction");
            return;
        } else {
            setCurrentRoom(roomConnected);
            System.out.println("You are now in " + roomConnected.getName());
            System.out.println(roomConnected.getShortDescription());
            for (i = 0; i < itemCount(); i++) {
                if (getCurrentLootId() == getAllItems().get(i).getIdValue()) {
                    System.out.println("Item(s) in the room: " + getAllItems().get(i).getName());
                }
            }
        }
    }

    /**
     * function to print out the short description of the current room
     */
    public void lookAround() {
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * 
     * @param toSee the inputted command containing the look value and the item name
     */
    public void lookAtSomething(Command toSee) {
        int j;

        for (j = 0; j < allItems.size(); j++) {
            if (toSee.getNoun().equals(allItems.get(j).getName())) {
                System.out.println(allItems.get(j).getLongDescription());
            }
        }
    }

    /**
     * 
     * @param toTake the command which is parsed to find the room item to take
     */
    public void pickUpItem(Command toTake) {
        int i = 0;

        for (i = 0; i < allItems.size(); i++) {
            if (allItems.get(i).getName().equals(toTake.getNoun())) {
                newPlayer.setUserItems(allItems.get(i));
                allItems.remove(i);
            }
        }
    }

    /**
     * lists all of the players current inventory
     */
    public void listInventory() {
        System.out.print("Your items in inventory: ");
        for (Item inventoryItem : newPlayer.getInventory()) {

            System.out.print(inventoryItem.getName() + " ");
        }
        System.out.println();
    }

    /**
     * function to save the adventure for future games
     * 
     * @param serializeAdventure adventure file to be serealized
     */
    public void saveGame(Adventure serializeAdventure) {
        Scanner scnr = new Scanner(System.in);
        String fileName;
        int inputValue;

        System.out.println("Would you like to save your game?");
        System.out.println("Enter 1 for yes or 0 for no");
        inputValue = scnr.nextInt();
        if (inputValue == 0) {
            scnr.close();
            return;
        } else if (inputValue == 1) {
            Scanner newScnr = new Scanner(System.in);
            System.out.println("Enter a filename for your saved game: ");

            fileName = newScnr.nextLine();

            SerializationDemo object = new SerializationDemo(serializeAdventure);
            object.printMe();

            // serialization steps
            try {
                // saving of object in a file
                FileOutputStream outPutStream = new FileOutputStream(fileName);
                ObjectOutputStream outPutDest = new ObjectOutputStream(outPutStream);

                // method for serialization of object
                outPutDest.writeObject(object);

                outPutDest.close();
                outPutStream.close();

                System.out.println("Game saved!");
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

}
