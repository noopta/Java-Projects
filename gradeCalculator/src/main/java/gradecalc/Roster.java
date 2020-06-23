package gradecalc;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import java.io.Reader;

public class Roster {
    private JSONObject jsonObject;
    private JSONArray theStudents;
    private ArrayList<Student> allStudents;

    /**
     * constructore for the Roster class
     */
    public Roster() {

    }

    /**
     * constructor for the Roster class initialized with a JSON filename
     * 
     * @param JSONFilename the json file which has the student info
     */
    public Roster(String JSONFilename) {
        allStudents = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        theStudents = null;
        jsonObject = new JSONObject();

        try (Reader reader = new FileReader(JSONFilename)) {
            jsonObject = (JSONObject) jsonParser.parse(reader);
            generateRoster();
        } catch (IOException e) {
            System.out.println("Error occured while opening the file");
        } catch (ParseException e) {
            System.out.println("Error occured while parsing");
        }
    }

    /**
     * function to generate the ArrayList of students
     */
    public void generateRoster() {
        Roster createRoster = new Roster();
        JSONObject rosterObj = new JSONObject();
        // Student currentStudent = new Student();

        theStudents = (JSONArray) jsonObject.get("students");

        for (Object currentObj : theStudents) {
            JSONObject studentObj = (JSONObject) currentObj;

            String currentName = (String) studentObj.get("name");
            String currentStream = (String) studentObj.get("stream");
            // Double currentExamGrade = (Double) studentObj.get("examGrade");

            // if it is a challenge student
            if (currentStream.equals("challenge")) {
                ChallengeStudent inputStudent = new ChallengeStudent();
                try {
                    Double currentProjectGrade = 0.0;
                    try {
                        currentProjectGrade = (Double) studentObj.get("projectGrade");
                        inputStudent.setProjectGrade(currentProjectGrade);
                    } catch (Exception e) {
                        Object o = (Object) studentObj.get("projectGrade");
                        Long convertToLong = (Long) o;
                        int convertedInt = convertToLong.intValue();
                        Double convertToDouble = Double.valueOf(convertedInt);
                        inputStudent.setProjectGrade(convertToDouble);
                    }

                    Double currentExamMark = 0.0;
                    try {
                        currentExamMark = (Double) studentObj.get("examGrade");
                        inputStudent.setExamGrade(currentExamMark);
                    } catch (Exception e) {
                        Object o = (Object) studentObj.get("examGrade");
                        Long convertToLong = (Long) o;
                        int convertedInt = convertToLong.intValue();
                        Double convertToDouble = Double.valueOf(convertedInt);
                        inputStudent.setExamGrade(convertToDouble);
                    }

                    inputStudent.setStudentName(currentName);
                    inputStudent.setStudentStream(currentStream);

                } catch (NullPointerException e) {
                    double currentProjectGrade = 0.0;
                    double currentExamMark = 0.0;
                }

                allStudents.add(inputStudent);
            }

            if (currentStream.equals("project")) {
                ProjectStudent inputStudent = new ProjectStudent();

                try {
                    int i = 0;
                    ArrayList<Double> inputArray;
                    inputArray = new ArrayList<>((ArrayList<Double>) studentObj.get("milestoneGrades"));

                    Double inputExamMark = 0.0;
                    try {
                        inputExamMark = (Double) studentObj.get("examGrade");
                        inputStudent.setExamGrade(inputExamMark);
                    } catch (Exception e) {
                        Object o = (Object) studentObj.get("examGrade");
                        Long convertToLong = (Long) o;
                        int convertedInt = convertToLong.intValue();
                        Double convertToDouble = Double.valueOf(convertedInt);
                        inputStudent.setExamGrade(convertToDouble);
                    }

                    Double midtermGrade = 0.0;
                    try {
                        midtermGrade = (Double) studentObj.get("midtermGrade");
                        inputStudent.setMidtermGrade(midtermGrade);
                    } catch (Exception e) {
                        Object o = (Object) studentObj.get("midtermGrade");
                        Long convertToLong = (Long) o;
                        int convertedInt = convertToLong.intValue();
                        Double convertToDouble = Double.valueOf(convertedInt);
                        inputStudent.setMidtermGrade(convertToDouble);
                    }

                    Boolean inputIsParticipating = (Boolean) studentObj.get("participating");

                    inputStudent.setStudentName(currentName);
                    inputStudent.setStudentStream(currentStream);
                    inputStudent.setIsParticipating(inputIsParticipating);

                    inputStudent.setMilestoneGrades(inputArray);

                } catch (NullPointerException e) {
                    inputStudent.setIsParticipating(false);
                }
                inputStudent.setMilestoneWeight();
                allStudents.add(inputStudent);
            }

            if (currentStream.equals("assignment")) {
                AssignmentStudent inputStudent = new AssignmentStudent();
                try {
                    ArrayList<Double> inputArray = new ArrayList<>((ArrayList<Double>) studentObj.get("quizGrades"));
                    ArrayList<Double> secondArray = new ArrayList<>(
                            (ArrayList<Double>) studentObj.get("assignmentGrades"));
                    Boolean inputIsParticipating = (Boolean) studentObj.get("participating");
                    Double currentMark = 0.0;
                    try {
                        currentMark = (Double) studentObj.get("examGrade");
                        inputStudent.setExamGrade(currentMark);
                    } catch (Exception e) {
                        Object o = (Object) studentObj.get("examGrade");
                        Long convertToLong = (Long) o;
                        int convertedInt = convertToLong.intValue();
                        Double convertToDouble = Double.valueOf(convertedInt);
                        inputStudent.setExamGrade(convertToDouble);
                    }

                    inputStudent.setStudentName(currentName);
                    inputStudent.setStudentStream(currentStream);

                    inputStudent.setIsParticipating(inputIsParticipating);
                    inputStudent.setAssignmentGrades(secondArray);
                    inputStudent.setQuizGrades(inputArray);

                } catch (NullPointerException e) {

                }
                allStudents.add(inputStudent);
            }

        }
    }

    /**
     * setter for the allStudents memebr variable
     * 
     * @param inputStudent the student to be added
     */
    public void setAllStudents(Student inputStudent) {
        allStudents.add(inputStudent);
    }

    /**
     * setter for the theStudents member variable
     * 
     * 
     * @param inputStudent the student to be added to the list
     */
    public void setTheStudents(Student inputStudent) {
        theStudents.add(inputStudent);
    }

    /**
     * 
     * setter for the jsonObect member variable
     * 
     * @param inputJson the jsonObject that contains all the student info
     */
    public void setJsonObject(JSONObject inputJson) {
        jsonObject = inputJson;
    }

    /**
     * returns all the students
     * 
     * @return the ArrayList of students
     */
    public ArrayList<Student> getStudents() {
        return allStudents;
    }

    public static void main(String[] args) {
        //
        Roster theRoster = new Roster("roster.json");
        int i = 0;

        for (Student theStudent : theRoster.getStudents()) {
            System.out.println("Name: " + theStudent.getStudentName());
            System.out.println("Student Stream: " + theStudent.getStudentStream());
            System.out.println("Final Grade: " + theStudent.finalGrade());
            System.out.println("****************************");
        }
        // System.out.println("Final mark for the challenge student: " +
        // theRoster.getStudents().get(0).finalGrade());
    }
}
