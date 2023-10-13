/*
 * 
 * The enrollment model is where we directly connect to the database tables.
 * 
 * */



import java.sql.*;
import java.util.*;

public class enrollmentsModel {

	private Connection connection;
    private String url = "jdbc:sqlserver://DESKTOP-R2MG0CS:1433;databaseName=University;integratedSecurity=true;encrypt=false";
    
    public enrollmentsModel() throws SQLException {
    		Connection connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQL Server database successful!");
            
            Scanner scanner= new Scanner(System.in);
	
	
}
    
    
    //a join query that retrieves all the courses that a certain student enrolled in.
    
    public static void studentCourses(Connection connection, int id) throws SQLException {
        String selectQuery = "SELECT c.course_name " +
                             "FROM course c " +
                             "INNER JOIN enrollment e ON c.course_id = e.course_id " +
                             "WHERE e.student_id = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setInt(1, id); // Set the student_id parameter
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println("The courses that the student " + id + " enrolled in are: ");
        while (resultSet.next()) {
            String courseName = resultSet.getString("course_name");
            System.out.println("Course: " + courseName);
        }
        
        resultSet.close();
        preparedStatement.close();
    }
    public static void addEnrollment(Connection connection, int student_id, int course_id) throws SQLException {
        String insertQuery = "INSERT INTO enrollment (course_id, student_id) VALUES (?, ?)";
        
        PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
        insertStatement.setInt(1, course_id);
        insertStatement.setInt(2, student_id);
        
        int rowsAffected = insertStatement.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Enrollment added successfully for student " + student_id + " and course " + course_id);
        } else {
            System.out.println("Failed to add enrollment.");
        }
        
        insertStatement.close();
    }
    
    //a join query that retrieves all the students enrolled in a certain course.
    public static void courseStudents(Connection connection, int id) throws SQLException {
        String selectQuery = "SELECT s.student_name " +
                             "FROM student s " +
                             "INNER JOIN enrollment e ON s.student_id = e.student_id " +
                             "WHERE e.course_id = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setInt(1, id); // Set the course_id parameter
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println("The students that are enrolled in course " + id + " are: ");
        while (resultSet.next()) {
            String studentName = resultSet.getString("student_name");
            System.out.println("Student: " + studentName);
        }
        
        resultSet.close();
        preparedStatement.close();
    }

    
    
    
    
    
}