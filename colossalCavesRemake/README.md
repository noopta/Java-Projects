Anupta Islam
anupta@uoguelph.ca

**INSTRUCTIONS FOR RUNNING THE COMMAND LINE INTERFACE PROGRAM**

To create the executable jar enter:
"mvn assembly:assembly"
"cd target"

TO LOAD A NEW GAME ENTER:
"java -jar TheGame-1.0-jar-with-dependencies.jar -a <loadable json file>"

OR TO LOAD A SAVED GAME ENTER:
"java -jar TheGame-1.0-jar-with-dependencies.jar -l <saved game name>"

**ONCE STARTING ROOM HAS LOADED ON THE CLI**
You can now begin playing the game.
You can only go back and forth between rooms that are connected. If an incorrect room direction is entered program will stop running. 
Enter "go N" to go to the Library. 
Once at the Library enter "go E" to go to the Mackinnon building.
Enter "S" from there to go to Rozanski hall. 
From Rozanski you can enter "go E" to go to the athletic centre. 
Enter "go up" to go to the second floor of the athletic cetnre and "go down" to return to the first floor.
This is the final room in the game.

You can also enter the opposite direction from which you came to go to the previous room. 
E.g. "go N" takes you to Mclaughlin library from the University Centre, enter "go S" from the Mclaughlin library to go back to the University Centre

**LOADING A SAVED GAME**
When you quit, you will be prompted to enter a name for your saved game.
To load that saved game, enter: "java -jar TheGame-1.0-jar-with-dependencies.jar -l <saved game name>" and deserialization should start.

**CLI GAME COMMANDS**
"look" : shows a description of the room you are in
"look <itemname>" : if there is an item in the room and you enter this command, a description of the item will be displayed
"take <itemname>" : if there is an item in the room and you take it, it is added to your inventory
"inventory" : displays your players current inventory
"quit" : user will be able to quit the game and is prompted if they want to save their current game
 
**DEFAULT ADVENTURE FILE**
My default adventure file is called "default_adventure.json"
The command to run a new default game would be: ""java -jar TheGame-1.0-jar-with-dependencies.jar -a default_adventure.json".





















