/*
 * 
 * The enrollment model is where we directly connect the database tables.
 * 
 * */

import java.sql.*;
import java.util.*;

public class coursesModel {
	private Connection connection;
    private String url = "jdbc:sqlserver://DESKTOP-R2MG0CS:1433;databaseName=University;integratedSecurity=true;encrypt=false";
    
    public coursesModel() throws SQLException {
    	
            Connection connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQL Server database successful!");
            Scanner scanner= new Scanner(System.in);
}
    
    public static void insertCourse(Connection connection, String name,int hall_id) throws SQLException {
        String insertQuery = "INSERT INTO course (course_name,hall_id) VALUES (?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, hall_id);
            preparedStatement.executeUpdate();
            System.out.println("course inserted successfully.");
        }
    }
    public static void viewCourses(Connection connection) throws SQLException {
        String selectQuery = "SELECT course_id, course_name, hall_id  FROM course";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {
            System.out.println("Course Details:");
            while (resultSet.next()) {
                int id = resultSet.getInt("course_id");
                String name = resultSet.getString("course_name");
                int location=resultSet.getInt("hall_id");
                
                System.out.println("ID: " + id + ", Name: " + name+", Hall: "+ location );
            }
        }
    }
    public static void updateCourseName(Connection connection,int id, String newName) throws SQLException {
        String updateQuery = "UPDATE course SET course_name = ? WHERE course_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Course name updated successfully.");
            } else {
                System.out.println("Course not found.");
            }
        }
    }
    public static void deleteCourse(Connection connection, int id) throws SQLException {
        String deleteQuery = "DELETE FROM course WHERE course_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Course deleted successfully."); 
            } else {
                System.out.println("Course not found.");
            }
        }
    
}
    
    
    
    
    
    
    
}