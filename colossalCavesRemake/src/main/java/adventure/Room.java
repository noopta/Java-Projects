package adventure;

import java.util.ArrayList;
import java.util.HashMap;

// room connects to item and references itself
public class Room implements java.io.Serializable {
    /* you will need to add some private member variables */

    /* required public methods */
    private HashMap<String, Long> connectedMapRooms; // done
    private final ArrayList<Long> connectedId; // done
    private ArrayList<String> oppositeDirections; // done
    private final ArrayList<Room> connectedRooms; // done
    private final ArrayList<Item> allRoomItems; // done
    private final ArrayList<String> entranceDirections; // done
    private final ArrayList<Item> allItems; // done
    private final ArrayList<Room> currentRoomVar;
    private ArrayList<Room> allRoomsHere; // done
    private String roomName; // done
    private String longDescription; // done
    private Long roomId; // done
    private Long lootId; // done
    private String shortDescription; // done
    private String getLongDescription; // done

    // private Room connectedRoomVar;

    public Room() {
        // connectedRoomVar = new Room();
        roomName = null; // done
        longDescription = null; // done
        roomId = null; // done
        lootId = null; // done
        shortDescription = null; // done
        getLongDescription = null; // done
        connectedId = new ArrayList<Long>(); // done
        oppositeDirections = new ArrayList<String>(); // done
        connectedRooms = new ArrayList<Room>(); // done
        allRoomItems = new ArrayList<Item>(); // done
        entranceDirections = new ArrayList<String>();
        allItems = new ArrayList<Item>(); // done
        currentRoomVar = new ArrayList<Room>(); // done
        allRoomsHere = new ArrayList<Room>();
        connectedMapRooms = new HashMap<String, Long>();

    }

    /**
     * overriding the toString method
     */
    @Override
    public String toString() {
        return String.format("Room name: " + roomName);
    }

    /**
     * setter for the opposite directions
     * 
     * @param inputDirections string of input directions
     */
    public void setOppositeDirections(ArrayList<String> inputDirections) {
        oppositeDirections = inputDirections;
    }

    /**
     * setter for the connectedMapRooms member variable
     * 
     * @param inputMap
     */
    public void setConnectedMapRooms(HashMap<String, Long> inputMap) {
        connectedMapRooms = inputMap;
    }

    // This is the old decleration: public ArrayList<Items> listItems(){
    /**
     * 
     * @param inputItem item to be added to the array of total items
     */
    public void setAllItems(final Item inputItem) {
        allItems.add(inputItem);
    }

    /**
     * 
     * @param inputName input name that is set as the room name
     */
    public void setRoomName(final String inputName) {
        roomName = inputName;
    }

    /**
     * 
     * @param inputDescription setting the room long description
     */
    public void setLongDescription(final String inputDescription) {
        longDescription = inputDescription;
    }

    /**
     * setter for the allRoomItems member variabl
     * 
     * @param roomItem adding the input item to the total items in the room
     */
    public void setAllRoomItems(final Item roomItem) {
        allRoomItems.add(roomItem);
    }

    /**
     * setter for the setConnectedRoom member variable
     * 
     * @param inputRoom the room input
     */
    public void setConnectedRoom(Room inputRoom) {
        int i;
        int j;
        // connectedRoomVar = inputRoom;
        /*
         * for (i = 0; i < currentAdventure.getCurrentRoom().connectedID.size(); i++) {
         * for (j = 0; j < currentAdventure.roomCount(); j++) { if
         * (currentAdventure.getCurrentRoom().connectedID.get(i) ==
         * currentAdventure.getAllRooms().get(j) .getRoomId()) { //
         * System.out.println("Connected room found: " + //
         * currentAdventure.getCurrentRoom().connectedID.get(i)); for (int k = 0; k <
         * currentAdventure.getAllRooms().size(); k++) { if
         * (currentAdventure.getCurrentRoom().connectedID.get(i) ==
         * currentAdventure.getAllRooms() .get(k).getRoomId()) {
         * connectedRooms.add(currentAdventure.getAllRooms().get(k)); } } } } }
         */

    }

    /**
     * 
     * @param inputAdventure the adventure object
     */
    public void setConnectedRooms(Adventure inputAdventure) {
        ArrayList<Room> totalRooms = new ArrayList<Room>();
        int i;

        for (i = 0; i < entranceDirections.size(); i++) {
            connectedMapRooms.put(entranceDirections.get(i), connectedId.get(i));
        }
        /*
         * totalRooms = inputAdventure.getAllRooms(); for (Room roomName : totalRooms) {
         * for (Long idValue : connectedID) { if (idValue == roomName.getRoomId()) {
         * 
         * // System.out.println("Connected room is: " + roomName.getName() + " and the
         * id // is: " + idValue); connectedMapRooms.put(roomName.getName(), idValue); }
         * } }
         */

    }

    /**
     * 
     * @param inputDescription the description being used as the short description
     *                         for the room
     */
    public void setShortDescription(final String inputDescription) {
        shortDescription = inputDescription;
    }

    /**
     * adds entrance directions to the array of entrance directions
     * 
     * @param entranceInput entrance direction
     */
    public void setEntranceDirections(final String entranceInput) {
        entranceDirections.add(entranceInput);
    }

    /**
     * adds the connected room id to the array of connected id's for that room
     * 
     * @param inputId the connected room id
     */
    public void setConnectedId(final Long inputId) {
        connectedId.add(inputId);
    }

    /**
     * sets the room id
     * 
     * @param inputId the input for the room id
     */
    public void setRoomId(final Long inputId) {
        roomId = inputId;
    }

    /**
     * sets the rooms loot id
     * 
     * @param inputId the value of the loot id
     */
    public void setLootId(final Long inputId) {
        lootId = inputId;
    }

    /**
     * 
     * @return returns all the entrance directions in an arrray of Strings
     */
    public ArrayList<String> listEntrances() {
        int i;
        for (i = 0; i < entranceDirections.size(); i++) {
            System.out.println(entranceDirections.get(i));
        }
        return entranceDirections;
    }

    /**
     * lists all the items in a room
     * 
     * @return array of items
     */
    public ArrayList<Item> listItems() {
        // lists all the items in the room
        int i;

        for (i = 0; i < allRoomItems.size(); i++) {
            System.out.println(allRoomItems.get(i).getName());
        }
        return allRoomItems;
    }

    /**
     * stter for the getLongDescription member variable
     * 
     * @param inputDescription input for the getLongDescription member variable
     */
    public void setGetLongDescription(String inputDescription) {
        getLongDescription = inputDescription;
    }

    /**
     * 
     * @param inputItem item to be found
     * @return the long description for that item if it is found
     */
    public String findItem(final String inputItem) {

        int i;

        for (i = 0; i < allRoomItems.size(); i++) {

            if (inputItem.equals(allRoomItems.get(i).getName())) {
                getLongDescription = allRoomItems.get(i).getLongDescription();

            }
        }

        return getLongDescription;
    }

    /**
     * 
     * @return the room name
     */
    public String getName() {
        return roomName;
    }

    /**
     * 
     * @return the room long description
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * setter for the currentRoomVar member variable
     * 
     * @param inputRoom input for the currentRoomVar member variable
     */
    public void setCurrentRoomVar(Room inputRoom) {
        currentRoomVar.add(inputRoom);
    }

    /**
     * 
     * @param inputAdventure the adventure that has the current room used in this
     *                       function
     */
    public void setPlayerRoom(final Adventure inputAdventure) {

        currentRoomVar.add(inputAdventure.getCurrentRoom());
    }

    /**
     * 
     * @return gets the array of entrance directions
     */
    public ArrayList<String> getEntranceDirections() {
        return entranceDirections;
    }

    /**
     * 
     * @param direction the input direction from the user
     * @return returns the connected room based off the input direction
     */

    public Room getConnectedRoom(String direction) {

        ArrayList<Long> totalIDs = new ArrayList<Long>(connectedMapRooms.values());

        if (connectedMapRooms.containsKey(direction)) {
            for (Room findRoom : allRoomsHere) {
                Long keyVal = connectedMapRooms.get(direction);
                if (keyVal == findRoom.getRoomId()) {
                    return findRoom;
                }
            }
        }
        return null;
    }

    /**
     * 
     * @return gets the short description of the room
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * 
     * @return gets the room id
     */
    public Long getRoomId() {
        return roomId;
    }

    /**
     * 
     * @return gets the loot id
     */
    public Long getLootId() {
        return lootId;
    }

    /**
     * 
     * @param inputAdventure sets all the rooms
     */
    public void setAllRoomsHere(final Adventure inputAdventure) {
        allRoomsHere = inputAdventure.getAllRooms();
    }
}
