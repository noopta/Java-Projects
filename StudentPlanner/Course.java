
/**
 * Write a description of class Course here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Course
{
    // instance variables - replace the example below with your own
    private String courseCode;
    private String courseTitle;
    private double courseCredit;
    private String courseStatus;
    private String courseGrade;
    private String semester;
    /**
     * Constructor for objects of class Course
     */
    public Course()
    {
        // initialise instance variables
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getCourseCode()
    {
        // put your code here
        return courseCode;
    }
    
    public void setCourseCode(String courseCode){
    this.courseCode = courseCode;
    return;
    }
    
    public String getCourseTitle(){
    
    return courseTitle;    
    }
    
    public void setCourseTitle(String courseTitle){
        this.courseTitle = courseTitle;
        return;
    }
    
    public double getCourseCredit(){
        return courseCredit;
    }
    
    public void setCourseCredit(double courseCredit){
      this.courseCredit = courseCredit;  
      return;
    }
    
    public void setCourseStatus(String courseStatus){
    this.courseStatus = courseStatus;
    return;
    }
    
    public String getCourseStatus(){
    return courseStatus;
    }
    
    public String getCourseGrade(){
    return courseGrade;
    }
    
    public void setCourseGrade(String grade){
    this.courseGrade = grade;
    return;
    }
    
    public String getSemesterTaken(){
    return semester;
    }
    
    public void setSemesterTaken(String semester){
    this.semester = semester;
    return;
    }
    
    
}
