package adventure;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

//import java.lang.ClassNotFoundException;

// 5 rooms 3 items for default adventure
public class Game implements java.io.Serializable {

    /*
     * this is the class that runs the game. You may need some member variables
     */

    private final JSONObject connectedObj;
    private JSONObject adventureObj;
    private JSONArray roomObj;
    private JSONArray itemObj;
    private final ArrayList<Room> getAllRooms;
    private final ArrayList<String> roomInformation;
    private final ArrayList<String> connectedRooms;
    private final Adventure totalRooms;
    private final Parser parser;
    private static Adventure theAdventure;
    private static String loadFile;
    // private String loopValue;

    /** constructore for the Game class initializing the class fields */
    public Game() {
        parser = new Parser();
        loadFile = null;
        adventureObj = null;
        roomObj = null;
        itemObj = null;
        connectedObj = new JSONObject();
        getAllRooms = new ArrayList<Room>();
        roomInformation = new ArrayList<String>();
        connectedRooms = new ArrayList<String>();
        totalRooms = new Adventure();
        theAdventure = new Adventure();
        // loopValue = null;
    }

    /**
     * overriding the toString method
     */
    @Override
    public String toString() {
        return String.format("Connected Room: " + getAllRooms.get(0));
    }

    /**
     * the main which is used to run the game loop
     * 
     * @param args command line arguements
     */
    public static void main(final String args[]) {
        // Room roomConnected = new Room();
        final Scanner scnr = new Scanner(System.in);
        final Scanner scnrTwo = new Scanner(System.in);
        Room roomConnected = new Room();
        Command nextCommand = null;

        String fileName;
        int gameOption;
        String inputDirection;
        String[] splitInput;
        JSONObject loadedObj = new JSONObject();
        final String loopValue;
        ArrayList<Item> loadItems = new ArrayList<Item>();
        /*
         * You will need to instantiate an object of type game as we're going to avoid
         * using static methods for this assignment
         */

        // System.out.println(testAdventure.listAllRooms());

        final Game theGame = new Game();
        final int gameLoop = 1;
        String gameInput = "input";
        String[] inputCount;
        int i;
        int j;
        int secondInput;

        if (args[0].equals("-l")) {
            System.out.println("loading saved file for default adventure");
            SerializationDemo gotItBack = null;
            final Scanner tempScnr = new Scanner(System.in);
            loadFile = args[1];
            // tempScnr.close();
            // Deserialization
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(loadFile));) {

                // Method for deserialization of object
                gotItBack = (SerializationDemo) in.readObject();

                System.out.println("Object has been deserialized ");
                // System.out.println("testing command arguments: " + args[0]);
                gotItBack.printMe();
                // loading saved adventure
                theAdventure = gotItBack.getSavedAdventure();
                loadItems = theAdventure.getAllItems();
                // connecting the current room
                roomConnected = theAdventure.getCurrentRoom();
                // roomConnected.setConnectedRoom(theAdventure);

                roomConnected.setPlayerRoom(theAdventure);
                roomConnected.setAllRoomsHere(theAdventure);

                System.out.println("Starting adventure in " + roomConnected.getName());
                System.out.println(roomConnected.getShortDescription());

                while (!gameInput.equals("quit")) {
                    roomConnected = theAdventure.getCurrentRoom();
                    // roomConnected.setConnectedRoom(theAdventure);

                    roomConnected.setPlayerRoom(theAdventure);
                    roomConnected.setAllRoomsHere(theAdventure);

                    // testing my new get connected room functions
                    roomConnected.setConnectedRooms(theAdventure);
                    // roomConnected.getConnectedRoom("N");

                    /** loop to get the user input */
                    System.out.println("What would you like to do next?");
                    final Scanner newScnr = new Scanner(System.in);
                    gameInput = newScnr.nextLine();
                    try {
                        nextCommand = theGame.parse(gameInput);
                    } catch (final InvalidCommandException e) {
                        // TODO Auto-generated catch block
                        // e.printStackTrace();
                        System.out.println("Invalid command");
                        System.out.println("What would you like to do next?");
                        gameInput = newScnr.nextLine();
                    }

                    // end of the loop
                    theGame.followCommands(nextCommand);

                    if (gameInput.equals("quit")) {
                        System.out.println("Exiting game.");
                    }
                }
            } catch (final IOException ex) {
                System.out.println("IOException is caught " + ex);
            } catch (final ClassNotFoundException ex) {
                System.out.println("ClassNotFoundException is caught " + ex);
            }
        }

        // ending of loading a saved game

        // loads a new adventure
        if (args[0].equals("-a")) {

            // System.out.println("Enter filename: ");
            fileName = args[1];

            // loadedObj = theGame.loadAdventureJson(fileName);
            // testing the overloaded method
            InputStream inputStream = new ByteArrayInputStream(fileName.getBytes());

            loadedObj = theGame.loadAdventureJson(inputStream);
            theAdventure = theGame.generateAdventure(loadedObj);
            loadItems = theAdventure.getAllItems();

            roomConnected = theAdventure.getCurrentRoom();
            // roomConnected.setConnectedRoom(theAdventure);

            roomConnected.setPlayerRoom(theAdventure);
            roomConnected.setAllRoomsHere(theAdventure);

            System.out.println("Starting adventure in " + roomConnected.getName());
            System.out.println(roomConnected.getShortDescription());

            /** this is the game loop */
            while (!gameInput.equals("quit")) {
                roomConnected = theAdventure.getCurrentRoom();
                // roomConnected.setConnectedRoom(theAdventure);

                roomConnected.setPlayerRoom(theAdventure);
                roomConnected.setAllRoomsHere(theAdventure);

                // testing my new get connected room functions
                roomConnected.setConnectedRooms(theAdventure);
                // roomConnected.getConnectedRoom("N");

                /** loop to get the user input */
                System.out.println("What would you like to do next?");
                final Scanner newScnr = new Scanner(System.in);
                gameInput = newScnr.nextLine();
                try {
                    nextCommand = theGame.parse(gameInput);
                } catch (final InvalidCommandException e) {
                    // TODO Auto-generated catch block
                    // e.printStackTrace();
                    System.out.println("Invalid command");
                    System.out.println("What would you like to do next?");
                    gameInput = newScnr.nextLine();
                }

                // end of the loop
                theGame.followCommands(nextCommand);

                if (gameInput.equals("quit")) {
                    System.out.println("Exiting game.");
                }
            }

        }
        // ending of command line -a file loading
        else if (args.length == 0) {

            System.out.println("Welcome to the game");
            System.out.println("Enter \"quit\" at any point to exit the program");
            // 1. Print a welcome message to the user
            System.out.println("Would you like to load a json file?");
            System.out.println("Enter 1 for yes or 0 to load a default adventure");
            // 2. Ask the user if they want to load a json file.
            gameOption = scnr.nextInt();

            final String string = "Item(s) in the room: ";
            if (gameOption == 1) {
                System.out.println("Enter filename: ");
                fileName = scnrTwo.nextLine();

                System.out.println("Do you have a saved file or would you like to start a new game?");
                System.out.println("Enter 1 for yes 0 for no");

                secondInput = scnr.nextInt();
                if (secondInput == 0) {
                    // loadedObj = theGame.loadAdventureJson(fileName);
                    // testing the overloaded method
                    InputStream inputStream = new ByteArrayInputStream(fileName.getBytes());

                    loadedObj = theGame.loadAdventureJson(inputStream);
                    theAdventure = theGame.generateAdventure(loadedObj);
                    loadItems = theAdventure.getAllItems();

                    roomConnected = theAdventure.getCurrentRoom();
                    // roomConnected.setConnectedRoom(theAdventure);

                    roomConnected.setPlayerRoom(theAdventure);
                    roomConnected.setAllRoomsHere(theAdventure);

                    System.out.println("Starting adventure in " + roomConnected.getName());
                    System.out.println(roomConnected.getShortDescription());

                    /** this is the game loop */
                    while (!gameInput.equals("quit")) {
                        roomConnected = theAdventure.getCurrentRoom();
                        // roomConnected.setConnectedRoom(theAdventure);

                        roomConnected.setPlayerRoom(theAdventure);
                        roomConnected.setAllRoomsHere(theAdventure);

                        // testing my new get connected room functions
                        roomConnected.setConnectedRooms(theAdventure);
                        // roomConnected.getConnectedRoom("N");

                        /** loop to get the user input */
                        System.out.println("What would you like to do next?");
                        final Scanner newScnr = new Scanner(System.in);
                        gameInput = newScnr.nextLine();
                        try {
                            nextCommand = theGame.parse(gameInput);
                        } catch (final InvalidCommandException e) {
                            // TODO Auto-generated catch block
                            // e.printStackTrace();
                            System.out.println("Invalid command");
                            System.out.println("What would you like to do next?");
                            gameInput = newScnr.nextLine();
                        }

                        // end of the loop
                        theGame.followCommands(nextCommand);

                        if (gameInput.equals("quit")) {
                            System.out.println("Exiting game.");
                        }
                    }
                } else if (secondInput == 1) {
                    System.out.println("loading saved file for default adventure");
                    SerializationDemo gotItBack = null;
                    final Scanner tempScnr = new Scanner(System.in);
                    loadFile = tempScnr.nextLine();
                    // tempScnr.close();
                    // Deserialization
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(loadFile));) {

                        // Method for deserialization of object
                        gotItBack = (SerializationDemo) in.readObject();

                        System.out.println("Object has been deserialized ");
                        // System.out.println("testing command arguments: " + args[0]);
                        gotItBack.printMe();
                        // loading saved adventure
                        theAdventure = gotItBack.getSavedAdventure();
                        loadItems = theAdventure.getAllItems();
                        // connecting the current room
                        roomConnected = theAdventure.getCurrentRoom();
                        // roomConnected.setConnectedRoom(theAdventure);

                        roomConnected.setPlayerRoom(theAdventure);
                        roomConnected.setAllRoomsHere(theAdventure);

                        System.out.println("Starting adventure in " + roomConnected.getName());
                        System.out.println(roomConnected.getShortDescription());

                        while (!gameInput.equals("quit")) {
                            roomConnected = theAdventure.getCurrentRoom();
                            // roomConnected.setConnectedRoom(theAdventure);

                            roomConnected.setPlayerRoom(theAdventure);
                            roomConnected.setAllRoomsHere(theAdventure);

                            // testing my new get connected room functions
                            roomConnected.setConnectedRooms(theAdventure);
                            // roomConnected.getConnectedRoom("N");

                            /** loop to get the user input */
                            System.out.println("What would you like to do next?");
                            final Scanner newScnr = new Scanner(System.in);
                            gameInput = newScnr.nextLine();
                            try {
                                nextCommand = theGame.parse(gameInput);
                            } catch (final InvalidCommandException e) {
                                // TODO Auto-generated catch block
                                // e.printStackTrace();
                                System.out.println("Invalid command");
                                System.out.println("What would you like to do next?");
                                gameInput = newScnr.nextLine();
                            }

                            // end of the loop
                            theGame.followCommands(nextCommand);

                            if (gameInput.equals("quit")) {
                                System.out.println("Exiting game.");
                            }
                        }
                    } catch (final IOException ex) {
                        System.out.println("IOException is caught " + ex);
                    } catch (final ClassNotFoundException ex) {
                        System.out.println("ClassNotFoundException is caught " + ex);
                    }
                }
            }
            /** loading default adventure */
            if (gameOption == 0) {
                System.out.println("Do you have a saved file or would you like to start a new game?");
                System.out.println("Enter 1 for yes or 0 to load a new game");

                secondInput = scnr.nextInt();
                if (secondInput == 0) {
                    if (args.length == 0) {
                        fileName = "default_adventure.json";
                    } else {
                        fileName = args[0];
                    }
                    // loadedObj = theGame.loadAdventureJson("default_adventure.json");
                    // using the overloaded load adventure json method
                    InputStream inputStream = new ByteArrayInputStream(fileName.getBytes());
                    loadedObj = theGame.loadAdventureJson(inputStream);

                    theAdventure = theGame.generateAdventure(loadedObj);
                    loadItems = theAdventure.getAllItems();
                    // System.out.println(loadItems.get(0));
                    // loading items into command

                    roomConnected = theAdventure.getCurrentRoom();
                    // roomConnected.setConnectedRoom(theAdventure);

                    roomConnected.setPlayerRoom(theAdventure);
                    roomConnected.setAllRoomsHere(theAdventure);

                    System.out.println("Starting adventure in " + roomConnected.getName());
                    System.out.println(roomConnected.getShortDescription());

                    while (!gameInput.equals("quit")) {
                        // theAdventure.listAllItems();
                        roomConnected = theAdventure.getCurrentRoom();
                        // roomConnected.setConnectedRoom(theAdventure);

                        roomConnected.setPlayerRoom(theAdventure);
                        roomConnected.setAllRoomsHere(theAdventure);

                        // testing my new get connected room functions
                        roomConnected.setConnectedRooms(theAdventure);
                        // roomConnected.getConnectedRoom("N");

                        /** loop to get the user input */
                        System.out.println("What would you like to do next?");
                        final Scanner newScnr = new Scanner(System.in);
                        gameInput = newScnr.nextLine();
                        try {
                            nextCommand = theGame.parse(gameInput);
                        } catch (final InvalidCommandException e) {
                            // TODO Auto-generated catch block
                            // e.printStackTrace();
                            System.out.println("Invalid command");
                            System.out.println("What would you like to do next?");
                            gameInput = newScnr.nextLine();
                        }

                        // end of the loop
                        theGame.followCommands(nextCommand);

                        if (gameInput.equals("quit")) {
                            System.out.println("Exiting game.");
                        }
                    }
                } else if (secondInput == 1) {
                    System.out.println("loading saved file for default adventure");
                    SerializationDemo gotItBack = null;
                    final Scanner tempScnr = new Scanner(System.in);
                    loadFile = tempScnr.nextLine();
                    // tempScnr.close();
                    // Deserialization
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(loadFile));) {

                        // Method for deserialization of object
                        gotItBack = (SerializationDemo) in.readObject();

                        System.out.println("Object has been deserialized ");
                        // System.out.println("testing command arguments: " + args[0]);
                        gotItBack.printMe();
                        // loading saved adventure
                        theAdventure = gotItBack.getSavedAdventure();
                        loadItems = theAdventure.getAllItems();
                        // connecting the current room
                        roomConnected = theAdventure.getCurrentRoom();
                        // roomConnected.setConnectedRoom(theAdventure);

                        roomConnected.setPlayerRoom(theAdventure);
                        roomConnected.setAllRoomsHere(theAdventure);

                        System.out.println("Starting adventure in " + roomConnected.getName());
                        System.out.println(roomConnected.getShortDescription());

                        while (!gameInput.equals("quit")) {
                            roomConnected = theAdventure.getCurrentRoom();
                            // roomConnected.setConnectedRoom(theAdventure);

                            roomConnected.setPlayerRoom(theAdventure);
                            roomConnected.setAllRoomsHere(theAdventure);

                            // testing my new get connected room functions
                            roomConnected.setConnectedRooms(theAdventure);
                            // roomConnected.getConnectedRoom("N");

                            /** loop to get the user input */
                            System.out.println("What would you like to do next?");
                            final Scanner newScnr = new Scanner(System.in);
                            gameInput = newScnr.nextLine();
                            try {
                                nextCommand = theGame.parse(gameInput);
                            } catch (final InvalidCommandException e) {
                                // TODO Auto-generated catch block
                                // e.printStackTrace();
                                System.out.println("Invalid command");
                                System.out.println("What would you like to do next?");
                                gameInput = newScnr.nextLine();
                            }

                            // end of the loop
                            theGame.followCommands(nextCommand);

                            if (gameInput.equals("quit")) {
                                System.out.println("Exiting game.");
                            }
                        }
                    } catch (final IOException ex) {
                        System.out.println("IOException is caught " + ex);
                    } catch (final ClassNotFoundException ex) {
                        System.out.println("ClassNotFoundException is caught " + ex);
                    }
                }
            }
        }
        /*
         * 3. Parse the file the user specified to create the adventure, or load your
         * default adventure
         */

        // 4. Print the beginning of the adventure

        // 5. Begin game loop here

        // 6. Get the user input. You'll need a Scanner

        /*
         * 7+. Use a game instance method to parse the user input to learn what the user
         * wishes to do
         */

        // use a game instance method to execute the users wishes*/

        /*
         * if the user doesn't wish to quit, repeat the steps above
         */
    }

    /* you must have these instance methods and may need more */
    /**
     * 
     * @param fileName the user inputted file name
     * @return returns a JSON object after parsing the file
     */
    public JSONObject loadAdventureJson(final String fileName) {
        final JSONParser jsonParser = new JSONParser();
        final JSONObject newObj = new JSONObject();

        try (Reader reader = new FileReader(fileName)) {

            final JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            return jsonObject;

        } catch (final IOException e) {
            e.printStackTrace();
            return newObj;
        } catch (final ParseException e) {
            e.printStackTrace();
            return newObj;
        }
    }

    /**
     * uses Scanner and the toString method to handle the input stream and create
     * the JSON object
     * 
     * @param inputStream input stream to be converted from bytes to a string
     * @return JSON object with all of the adventure information
     */
    public JSONObject loadAdventureJson(InputStream inputStream) {
        Scanner getStream = new Scanner(inputStream);
        final JSONParser jsonParser = new JSONParser();
        final JSONObject newObj = new JSONObject();
        String fileName = null;

        fileName = getStream.nextLine().toString();

        try (Reader reader = new FileReader(fileName)) {

            final JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            return jsonObject;

        } catch (final IOException e) {
            e.printStackTrace();
            return newObj;
        } catch (final ParseException e) {
            e.printStackTrace();
            return newObj;
        }
    }

    /**
     * 
     * @param obj the json object which contains the adventure information
     * @return the adventure to be loaded
     */
    public Adventure generateAdventure(final JSONObject obj) {
        final Adventure createAdventure = new Adventure();
        adventureObj = (JSONObject) obj.get("adventure");
        roomObj = (JSONArray) adventureObj.get("room");
        // iterates through each object
        for (Object currentRoomObj : roomObj) {
            JSONObject rooms = (JSONObject) currentRoomObj;
            Room getRooms = new Room();
            String currentNameVar = (String) rooms.get("name");
            String currentShortDescription = (String) rooms.get("short_description");
            String currentLongDescription = (String) rooms.get("long_description");
            Long currentRoomId = (Long) rooms.get("id");
            // code below gets entrance variables per room
            final JSONArray currentEntrance = (JSONArray) rooms.get("entrance");
            for (final Object currentDirection : currentEntrance) {
                final JSONObject nearby = (JSONObject) currentDirection;
                final String currentDir = (String) nearby.get("dir");
                final Long currentIdVal = (Long) nearby.get("id");

                // System.out.println("ID: " + currentIdVal + " direction " + currentDir);
                getRooms.setEntranceDirections(currentDir);
                getRooms.setConnectedId(currentIdVal);
            }

            JSONArray getLoot = (JSONArray) rooms.get("loot");
            if (getLoot == null) {
                // System.out.println("No loot in this room");
                getLoot = new JSONArray();
            } else {
                for (final Object currentLoot : getLoot) {
                    final JSONObject lootObj = (JSONObject) currentLoot;
                    final Long currLootId = (Long) lootObj.get("id");
                    getRooms.setLootId(currLootId);
                    // System.out.println(getRooms.getLootId());
                }
            }
            // creates a room vairable, adds the name and description and
            // passes it to the adventure variable
            // each iteration a new room temporary room variable is made
            getRooms.setRoomId(currentRoomId);
            getRooms.setRoomName(currentNameVar);
            getRooms.setLongDescription(currentLongDescription);
            getRooms.setShortDescription(currentShortDescription);
            // adding a room per iteration
            createAdventure.setAllRooms(getRooms);
            if (createAdventure.roomCount() == 1) {
                createAdventure.setCurrentRoom(getRooms);
            }
        }
        // Room next_room = new Room();
        // next_room.setName(currentNameVar);
        // System.out.println(next_room.getName());
        // }
        itemObj = (JSONArray) adventureObj.get("item");
        for (final Object currentRoomObj : itemObj) {
            final JSONObject rooms = (JSONObject) currentRoomObj;
            final String currentNameVar = (String) rooms.get("name");
            final String currentItemDescription = (String) rooms.get("desc");
            final Long currentIdVal = (Long) rooms.get("id");
            final Item getItems = new Item();

            getItems.setName(currentNameVar);
            getItems.setLongDescription(currentItemDescription);
            getItems.setIdValue(currentIdVal);
            createAdventure.setAllItems(getItems);
        }
        return createAdventure;
    }

    /**
     * private helper function to parse the user input, function has to be made
     * because the private Parser object can't be accesses from the static main
     * 
     * @param userInput the input string that the user enters
     * @return returns either a Command object with just the verb initialized or
     *         with both verb and noun depending on the user input
     * @throws InvalidCommandException
     */
    private Command parse(final String userInput) throws InvalidCommandException {
        return parser.parseUserCommand(userInput);
    }

    /**
     * 
     * @param toDo the Command which contains the user input for what to do
     */
    private void followCommands(final Command toDo) {
        if (toDo.getActionWord().equals("go")) {
            System.out.println("moving rooms");
            theAdventure.moveHero(toDo);
        } else if (toDo.getActionWord().equals("look")) {
            if (toDo.hasSecondWord()) {
                theAdventure.lookAtSomething(toDo);

            } else {
                theAdventure.lookAround();
            }
        } else if (toDo.getActionWord().equals("quit")) {
            theAdventure.saveGame(theAdventure);
        } else if (toDo.getActionWord().equals("take")) {
            System.out.println("picking up " + toDo.getNoun());
            theAdventure.pickUpItem(toDo);
        } else if (toDo.getActionWord().equals("inventory")) {
            theAdventure.listInventory();
        }
    }

}
