import java.sql.*;
import java.util.*;


public class View {

	public static void main(String[] args) throws SQLException {
		 
		Scanner scanner= new Scanner(System.in);
		
		
			System.out.println("choose the table you want to work on : ");
			System.out.println("1: Students table.");
			System.out.println("2: Courses table.");
			System.out.println("3: Halls 'Locations' table.");
			System.out.println("4: Enrollments table.");
			
			
			int table = scanner.nextInt();
			switch(table) {
			
				case 1 :
					studentsController student= new studentsController();
					break;
				case 2 : 
					coursesController course=new coursesController();
					break;
				case 3: 
					hallsController hall=new hallsController();
					break;
				case 4: 
					enrollmentsController enrol=new enrollmentsController();
					break;
				default:
                     System.out.println("Invalid choice. Please select a valid option.");
             
			}
			
		
		
	}

}
