Anupta Islam
anupta@uoguelph.ca
1007108

I, Anupta Islam, did the work for this assignment on my own and without coying work from any other sources.


**Running The Program**

For a default adventure: 
- enter the command "mvn compile"
- once compiled, enter "mvn exec:java" to launch the code 
- enter the value of "0" at the first prompt where you will then be asked if you want to load a saved file or start from scratch
- enter 1 if you have a saved file and 0 if you do not

For loading a saved game in a default adventure:
- enter the command "mvn compile"
- once compiled, enter "mvn exec:java" to launch the code 
- enter the value of "0" at the first prompt where you will then be asked if you want to load a saved file or start from scratch
- enter 1 if you have a saved file
- desearilization should begin if the file name is correct

For a loadable adventure:
- enter the command "mvn compile"
- once compiled, enter "mvn exec:java" to launch the code 
- enter the value of "1" at the first prompt where you will then be asked if you want to load a saved file or start from scratch
- enter 1 if you have a saved file and 0 if you do not

For loading a saved game in a loadable adventure:
- enter the command "mvn compile"
- once compiled, enter "mvn exec:java" to launch the code 
- enter the value of "1" at the first prompt where you will then be asked if you want to load a saved file or start from scratch
- enter 1 if you have a saved file
- desearilization should begin if the file name is correct

**Locations Of Some Of The Bigger Requirements**
- Map data structure for entrances / exits : Lines 11, 43, 108, 258 in Room.java
- public JSONObject loadAdventureJSON(InputStream inputStream): Line 410 in Game.java

**For Quitting**
- Type "quit" to exit the game
- you will be prompted to either save the game or exit enter 1 to save or 0 to just leave
- after the scanner will be waiting for your input, type "quit" as there won't be anything left to do in the game






















