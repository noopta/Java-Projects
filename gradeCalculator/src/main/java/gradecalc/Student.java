package gradecalc;

import java.util.ArrayList;

public class Student {

    private String studentName; // done
    private String studentStream; // done
    private Double projectGrade; // done
    private double examGrade; // done
    private ArrayList<Double> milestoneGrades; // done
    private Boolean isParticipating; // done
    private ArrayList<Double> quizGrades; // done
    private ArrayList<Double> assignmentGrades; // done
    private Double midtermGrade; // done

    public Student() {
        midtermGrade = null; // done
        studentName = null; // done
        studentStream = null; // done
        projectGrade = null; // done
        examGrade = 0.0; // done
        milestoneGrades = null; // done
        isParticipating = false; // done
        quizGrades = null; // done
        assignmentGrades = null; // done
    }

    /**
     * helper function to print an array of Doubles
     * 
     * @param inputArray the array to be printed
     */
    public void printArray(ArrayList<Double> inputArray) {
        int i = 0;
        for (i = 0; i < inputArray.size(); i++) {
            System.out.print(inputArray.get(i) + " ");
        }
    }

    // setters below
    /**
     * setter for the studentName member variable
     * 
     * @param inputName the input student name
     */
    public void setStudentName(String inputName) {
        studentName = inputName;
    }

    /**
     * setter for the midtermGrade member variable
     * 
     * @param inputGrade the input grade
     */
    public void setMidtermGrade(Double inputGrade) {
        midtermGrade = inputGrade;
    }

    /**
     * setter for the studentStream member variable
     * 
     * @param inputStream the type of student stream
     */
    public void setStudentStream(String inputStream) {
        studentStream = inputStream;
    }

    /**
     * setter for the projectGrade member variable
     * 
     * @param inputGrade the input grade
     */
    public void setProjectGrade(Double inputGrade) {
        projectGrade = inputGrade;
    }

    /**
     * setter for the examGrade member variable
     * 
     * @param inputGrade the exam grade
     */
    public void setExamGrade(double inputGrade) {
        examGrade = inputGrade;
    }

    /**
     * setter for the milestoneGrades member variable
     * 
     * @param inputGrade the array of milestone grades
     */
    public void setMilestoneGrades(ArrayList<Double> inputGrade) {
        milestoneGrades = new ArrayList<Double>(inputGrade);
    }

    /**
     * setter for the isParticipating member variable
     * 
     * @param inputValue variable saying if the student participated or not
     */
    public void setIsParticipating(boolean inputValue) {
        isParticipating = inputValue;
    }

    /**
     * setter for the quizGrades member variable
     * 
     * @param inputGrade the quiz grades
     */
    public void setQuizGrades(ArrayList<Double> inputGrade) {
        quizGrades = new ArrayList<Double>(inputGrade);
    }

    /**
     * setter for the assignmentGrades member variable
     * 
     * @param inputGrade the assignment grades
     */
    public void setAssignmentGrades(ArrayList<Double> inputGrade) {
        assignmentGrades = new ArrayList<Double>(inputGrade);
    }

    // getters below
    /**
     * gets the studentName member variable
     * 
     * @return the student name
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * gets the midtermGrade member variable
     * 
     * @return the midterm grade
     */
    public Double getMidtermGrade() {
        return midtermGrade;
    }

    /**
     * returns the studentStream member variable
     * 
     * @return the students stream
     */
    public String getStudentStream() {
        return studentStream;
    }

    /**
     * gets the projectGrade member variable
     * 
     * @return the students project grade
     */
    public Double getProjectGrade() {
        return projectGrade;
    }

    /**
     * gets the examGrade member variable
     * 
     * @return the students exam grade
     */
    public double getExamGrade() {
        return examGrade;
    }

    /**
     * gets the milestoneGrades member variable
     * 
     * @return the milestone grades
     */
    public ArrayList<Double> getMilestoneGrades() {
        return milestoneGrades;
    }

    /**
     * gets the isParticipating member variable
     * 
     * @return says is the student participated or not
     */
    public boolean getIsParticipating() {
        return isParticipating;
    }

    /**
     * gets the quizGrades member variable
     * 
     * @return the quiz grades
     */
    public ArrayList<Double> getQuizGrades() {
        return quizGrades;
    }

    /**
     * gets the assignmentGrades member variable
     * 
     * @return the students assignment grades
     */
    public ArrayList<Double> getAssignmentGrades() {
        return assignmentGrades;
    }

    /**
     * finalGrade method to be overriden
     * 
     * @return the students overall grade
     */
    public double finalGrade() {

        return 0.0;
    }

    /**
     * overriden toString method
     */
    @Override
    public String toString() {
        return ("Student class");
    }
}
