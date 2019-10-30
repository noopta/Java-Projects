
import java.util.ArrayList;
import java.util.*;

/**
 * Write a description of class CS here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CS extends HonoursDegree
{
    // instance variables - replace the example below with your own
    public String degree;
    public ArrayList<String> listofRequiredCourses;
    /**
     * Constructor for objects of class CS
     */
    public CS()
    {
            // initialise instance variables
            listofRequiredCourses = new ArrayList();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getDegree()
    {
        // put your code here
        return degree;
    }
    
    public void setDegreeTitle(String degree){
    this.degree = degree;
    }
    
    public void setRequiredCourses(ArrayList<String>listofRequiredCourses){
    
     this.listofRequiredCourses = listofRequiredCourses;
        
    }
    
    
}
