import java.util.ArrayList;

/**
 * Write a description of class PlanOfStudy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlanOfStudy
{
    // instance variables 
    private String courseCode;
    private String semester;
    private String course; 
    private String courseStatus;
    private String Grade; 
    private Course C;
    private  ArrayList<Course> myCourses = new ArrayList<Course>();
    private Degree d = new Degree();
    /**
     * Constructor for objects of class PlanOfStudy
     */
    public PlanOfStudy()
    {
        // initialise instance variables
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public String getCourseTitle(){
    
    return course;
    }
    
    public void setCourseStatus(String courseCode, String semester, String courseStatus){
    
        this.semester = semester; 
        this.courseCode = courseCode;
        this.courseStatus = courseStatus;
        
        return;
    }
    
    public void setCourseGrade(String courseCode, String semester, String Grade){
    
        this.courseCode = courseCode;
        this.semester = semester;
        this.Grade = Grade;
        return;
    
    }
    
    public void addCourse(String courseCode, String semester){
    
        Course c = new Course();
        
        c.setCourseCode(courseCode);
        c.setSemesterTaken(semester);
        
        myCourses.add(c);  
        for(int i=0; i< myCourses.size();i++){
            System.out.println(myCourses.get(i));
        }
        return;
    }
 }

