import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
/**imports*/
public class Planner {
    /**variable declerations*/
    public static String degree;
    public static String major;
    public static ArrayList<String> readCode = new ArrayList<String>();
    public static ArrayList<String> readCourses = new ArrayList<String>();
    public static ArrayList<String> readPrereq = new ArrayList<String>();
    public static Scanner reader = new Scanner(System.in);
    public static Scanner readerTwo = new Scanner(System.in);
    public String input;
    public static PlanOfStudy p = new PlanOfStudy();
    
    /*
    public String major(){
        
        System.out.println("Enter your degree \n");
        degree = reader.next();
        
        
        switch(degree){
        
            case "BCH": 
            System.out.println("What is your major?");
            major = readerTwo.next();
            //System.out.println(major);
            break;
            
            case "BCG":
            System.out.println("What is your major?");
            major = readerTwo.next();
            break;
            
            default: 
            System.out.println("Please select either BCH or BCG");
            
        }
       
    return degree;
    }
    */
    public static void main() {
        /** variable decleraetions*/
        String csvFile = "CourseList.txt";
        String line = "";
        String cvsSplitBy = ",";
        String splitter = ":";
        Scanner userInput = new Scanner(System.in); 
        Scanner codeInput = new Scanner(System.in);
        Scanner semesterInput = new Scanner(System.in);
        String input;
        String Code;
        String semesterName;
        
        /**menu*/
        
        System.out.println("What would you like to do?");
        System.out.println("1.Read the CSV file");
        System.out.println("2.Select your degree and major");
        System.out.println("3.Add courses to my PlanOfStudy");
        System.out.println("4.");
        System.out.println("5.");
        System.out.println("6.");
        
        input = userInput.next();
        /**read the csv file and print*/
        switch(input){ 
            
            case "1":
        int lineCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

             while((line = br.readLine()) != null) {
                lineCount++;
                //System.out.println(line);  
                // creating string tokenizer
                  StringTokenizer st = new StringTokenizer(line,",");
                
                  // counting tokens
                  //System.out.println(/*"Total tokens : " +*/ st.countTokens()); 
            
                  //get Course code
                  String courseCode = "";
                  String credits = "";
                  String stringName = "";
                  if (st.hasMoreTokens()) {
                     courseCode = st.nextToken();
                     readCode.add(courseCode);
              }
                if(st.hasMoreTokens()){
                    credits = st.nextToken();
                    readCourses.add(credits);
                }
                if(st.hasMoreTokens()){
                stringName = st.nextToken();
                readPrereq.add(stringName);
                }
                
                
               System.out.println(courseCode + " " + credits + " " + stringName);
                // use comma as separator
                //String[] country = line.split(cvsSplitBy);
                
                //System.out.println( country[0] +" "+ country[1] +" "+  country[2] );

            }
            System.out.println("Number of Lines" + lineCount );
            /*for(int i=0;i<readCode.size();i++){
            System.out.println(readPrereq.get(i));
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        break;
        
        case "2":
        System.out.println("Enter your degree \n");
        degree = reader.next();
        
        
        switch(degree){
        
            case "BCH": 
            System.out.println("What is your major?");
            major = readerTwo.next();
            //System.out.println(major);
            break;
            
            case "BCG":
            System.out.println("What is your major?");
            major = readerTwo.next();
            break;
            
            default: 
            System.out.println("Please select either BCH or BCG");
            
        }
        break;
        
        /**code three*/
        case "3":
        System.out.println("Enter your course code and semester");
        Code = codeInput.next();
        semesterName = semesterInput.next();
        
        p.addCourse(Code, semesterName);
                
        break;
        
        
    }

        
        
    }

}


