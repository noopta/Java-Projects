// Java code for serialization and deserialization 
// of a Java object  
package adventure;

class SerializationDemo implements java.io.Serializable {
	// your IDE will generate this if you want, or use serialver on the command line
	private static final long serialVersionUID = -3788086098781612036L;
	private Adventure savedAdventure;
	private String aName;

	/**
	 * 
	 * @param inputAdventure the adventure to be serialized
	 */
	SerializationDemo(Adventure inputAdventure) {
		savedAdventure = new Adventure();
		savedAdventure = inputAdventure;
	}

	/**
	 * function to test if the serialization worked and if the saved adventure
	 * variable is working
	 */
	public void printMe() {
		System.out.println("Current Room: " + savedAdventure.getCurrentRoomDescription());
	}

	/**
	 * 
	 * @return returns the saved adventure field
	 */
	public Adventure getSavedAdventure() {
		return savedAdventure;
	}

}
