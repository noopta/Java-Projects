anupta@uoguelph.ca
1007108
CIS 2430 
Final Exam Project

**** RUNNING MY PROGRAM *****

1. Clone the repository to your computer.
2. Use cd to navigate into the "finalexam" directory.
3. Enter "mvn compile" into the command line and hit enter.
4. To run the main on my Roster.java file and see the results of all the students grades, enter "mvn exec:java".

Something to keep in mind too is that to instantiate the array of students, creating the JSON object, parsing the object, etc. make sure 
you instantiate a Roster object with the json file as the paramter. 
E.g. "Roster exampleRoster = new Roster("roster.json");".

All of my java files are in the "gradecalc" directory. The path would be "src/java/main/gradecakc".

For the reasearchPerk() method I assumed the 5% bonus was 5% of the maximum possible grade a student could get for their stream. For example,
in the "assignment" stream the maximum grade is capped at 60%. So I took 5% of 60, which is 3, then added that to the students calculated grade
if they participated. Same idea for the "project" stream student but this time it is 5% of 100 (the maximum possible grade). So I took the 
calculated grade and added 5 if the student participated.


