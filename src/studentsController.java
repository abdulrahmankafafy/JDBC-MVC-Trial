import java.sql.*;
import java.util.*;;

public class studentsController {
	private Connection connection;
    private String url = "jdbc:sqlserver://DESKTOP-R2MG0CS:1433;databaseName=University;integratedSecurity=true;encrypt=false";
    
    public studentsController() throws SQLException {
    		Connection connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQL Server database successful!");
            
            Scanner scanner= new Scanner(System.in);
            
            studentsModel model = new studentsModel();
            
            
            while (true) {
                System.out.println("\nSelect a CRUD operation:");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student Name");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                       
                        model.insertStudent(connection, name);
                        break;
                    case 2:
                        model.viewStudents(connection);
                        break;
                    case 3:
                        System.out.print("Enter student ID: ");
                        int idToUpdate = scanner.nextInt();
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        model.updateStudentName(connection, idToUpdate,newName);
                        break;
                    case 4:
                        System.out.print("Enter student ID to delete: ");
                        int idToDelete = scanner.nextInt();
                        model.deleteStudent(connection, idToDelete);
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

