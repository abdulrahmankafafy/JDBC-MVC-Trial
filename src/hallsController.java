import java.sql.*;
import java.util.Scanner;

public class hallsController {
	private Connection connection;
    private String url = "jdbc:sqlserver://DESKTOP-R2MG0CS:1433;databaseName=University;integratedSecurity=true;encrypt=false";
    
    public hallsController() throws SQLException {
    	 Connection connection = DriverManager.getConnection(url);
         System.out.println("Connection to SQL Server database successful!");
         Scanner scanner= new Scanner(System.in);
         
         hallsModel model=new hallsModel();
         
         
         while (true) {
             System.out.println("\nSelect a CRUD operation:");
             System.out.println("1. Add a hall");
             System.out.println("2. View available halls");
             System.out.println("3. Update the hall");
             System.out.println("4. Delete a hall");
             System.out.println("5. Exit");
             System.out.print("Enter your choice: ");

             int choice = scanner.nextInt();
             scanner.nextLine(); 

             switch (choice) {
                 case 1:
                     System.out.print("Enter the hall's name: ");
                     String name = scanner.nextLine();
                    
                     model.insertHall(connection, name);
                     break;
                 case 2:
                	 model.viewHalls(connection);
                     break;
                 case 3:
                     System.out.print("Enter Hall's ID: ");
                     int idToUpdate = scanner.nextInt();
                     System.out.print("Enter new Hall's name: ");
                     String newName = scanner.nextLine();
                     model.updateHallName(connection, idToUpdate,newName);
                     break;
                 case 4:
                     System.out.print("Enter Hall ID to delete: ");
                     int idToDelete = scanner.nextInt();
                     model.deleteHall(connection, idToDelete);
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

