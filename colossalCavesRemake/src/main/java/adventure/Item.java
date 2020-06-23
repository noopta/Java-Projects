package adventure;

public class Item implements java.io.Serializable {
    /* you will need to add some private member variables */

    /* required public methods */

    private String longDescription;
    private String name;
    private Room containingRoom;
    private Long idValue;

    /**
     * constructor for the Item class
     */
    public Item() {
        longDescription = null;
        name = null;
        containingRoom = null;
        idValue = null;
    }

    /**
     * overriding the toString method
     */
    @Override
    public String toString() {
        return String.format("Item name: " + name);
    }

    /**
     * 
     * @param setName string to be put as the item name
     */
    public void setName(String setName) {
        name = setName;
    }

    /**
     * 
     * @param setLongDescription string to be set as the long description
     */
    public void setLongDescription(String setLongDescription) {
        longDescription = setLongDescription;
    }

    /**
     * 
     * @param inputValue id to be inputted as the items id value
     */
    public void setIdValue(Long inputValue) {
        idValue = inputValue;
    }

    /**
     * setter for the containingRoom member variable
     * 
     * @param inputRoom input assigned to the containingRoom member variable
     */
    public void setContainingRoom(Room inputRoom) {
        containingRoom = inputRoom;
    }

    /**
     * 
     * @return returns the item name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return returns the long description
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * 
     * @return returns the room the item is contained in
     */
    public Room getContainingRoom() {
        // returns a reference to the room that contains the item

        return containingRoom;
    }

    /**
     * 
     * @return gets the id value of the item
     */
    public Long getIdValue() {
        return idValue;
    }

    /* you may wish to add some helper methods */
}
