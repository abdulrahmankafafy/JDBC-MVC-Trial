import java.sql.*;
import java.util.*;;

public class enrollmentsController {
	private Connection connection;
    private String url = "jdbc:sqlserver://DESKTOP-R2MG0CS:1433;databaseName=University;integratedSecurity=true;encrypt=false";
    
    public enrollmentsController() throws SQLException {
    		Connection connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQL Server database successful!");
            
            Scanner scanner= new Scanner(System.in);
            
            
            enrollmentsModel model= new enrollmentsModel();
            
            while (true) {
                System.out.println("\nSelect an operation:");
                System.out.println("1. assign a student to a course");
                System.out.println("2. Get all courses a student is enrolled in");
                System.out.println("3. Get all students enrolled in a course");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                    	System.out.print("Enter the student's ID : ");
                    	int student_id = scanner.nextInt();
                    	System.out.print("Enter the courses's ID : ");
                    	int course_id = scanner.nextInt();
                    	model.addEnrollment(connection, student_id, course_id);
                        break;
                    case 2:
                    	System.out.print("Enter the student's ID : ");
                         student_id = scanner.nextInt();
                       
                         model.studentCourses(connection,student_id);
                        break;
                        
                    case 3: 
                    	System.out.print("Enter the course's ID : ");
                        course_id = scanner.nextInt();
                      
                        model.courseStudents(connection,course_id);
                       break;
                    	
                    
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                
                }
            }
    }
    
//
    
    
    
    
    
    
}