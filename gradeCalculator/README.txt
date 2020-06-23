anupta@uoguelph.ca
1007108
CIS 2430 
Final Exam Project

****MAVEN IS REQUIRED TO RUN MY PROGRAM****

**** RUNNING MY PROGRAM *****

1. Clone the repository to your computer.
2. Use cd to navigate into the "finalexam" directory.
3. Enter "mvn compile" into the command line and hit enter.
4. To run the main on my Roster.java file and see the results of all the students grades, enter "mvn exec:java".

Something to keep in mind too is that to instantiate the array of students, creating the JSON object, parsing the object, etc. make sure 
you instantiate a Roster object with the json file as the parameter. 
E.g. "Roster exampleRoster = new Roster("roster.json");".

All of my java files are in the "gradecalc" directory. The path would be "src/java/main/gradecalc".

For the reasearchPerk() method I assumed the 5% bonus was 5% of the maximum possible grade a student could get for their stream. For example,
in the "assignment" stream the maximum grade is capped at 60%. So I took 5% of 60, which is 3, then added that to the students calculated grade
if they participated. Same idea for the "project" stream student but this time it is 5% of 100 (the maximum possible grade). So I took the 
calculated grade and added 5 if the student participated.

****WHAT THIS PROGRAM DOES****
A university programming course (in some fictional university) has three possible streams for students taking the course.  
 A student can take the project stream of the course, in which case they will write a midterm, a final exam,  and do three project milestones as coursework.   The maximum possible final grade for a student in the project stream is 100%.   The final grade for a project stream student is calculated as 20% per project milestone, 20% midterm, 20% final.
 
A student can take the assignment stream of the course.  The student will write three quizzes instead of a midterm,  will write the same final exam, and will do 10 homework assignments.  This stream of the course moves more slowly than the project stream and covers only the crucial material from the course.  The maximum possible final grade for someone in the assignment stream is capped at 60% as they will never be taught approximately 40% of the more advanced material.  The final grade for an assignment stream student is calculated as 20% final 10% for each quiz and 5% for each assignment.  

Students with documented prior experience in the course content may attempt the challenge stream of the course.   Challenge stream students do a single project and a single exam for the course.  The  maximum final grade for a student in the challenge stream is 100.  The final grade for a challenge stream student is calculated as 50% exam and 50% project

Students in the project stream or the assignment stream may earn a bonus of  5% of their maximum possible grade (applied to their total course grade) by participating in research studies as a research subject.  The final grade may never exceed the maximum grade for that stream.

My program parses through the JSON file and extracts the student information. From there I determine which stream the student is in and create subclasses of Student.java based on that. Their grade is calculated based on their subclass / stream.


