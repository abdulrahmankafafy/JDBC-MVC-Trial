import java.sql.*;
import java.util.Scanner;

public class coursesController {
	private Connection connection;
    private String url = "jdbc:sqlserver://DESKTOP-R2MG0CS:1433;databaseName=University;integratedSecurity=true;encrypt=false";
    
    public coursesController() throws SQLException {
    	
            Connection connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQL Server database successful!");
            Scanner scanner= new Scanner(System.in);
            
            coursesModel model = new coursesModel();
            
            
            
            while (true) {
                System.out.println("\nSelect a CRUD operation:");
                System.out.println("1. Add course");
                System.out.println("2. View available courses");
                System.out.println("3. Update the courses");
                System.out.println("4. Delete a course");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.print("Enter the course's name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter the halls id: ");
                        int hall_id=scanner.nextInt();
                        model.insertCourse(connection, name,hall_id);
                        break;
                    case 2:
                    	model.viewCourses(connection);
                        break;
                    case 3:
                        System.out.print("Enter course ID: ");
                        int idToUpdate = scanner.nextInt();
                        System.out.print("Enter new course name: ");
                        String newName = scanner.nextLine();
                        model.updateCourseName(connection, idToUpdate,newName);
                        break;
                    case 4:
                        System.out.print("Enter course ID to delete: ");
                        int idToDelete = scanner.nextInt();
                        model.deleteCourse(connection, idToDelete);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                
                }
            }
            
            
            
    }
    
    
    
    
}

