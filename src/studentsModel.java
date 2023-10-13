import java.sql.*;
import java.util.Scanner;

public class studentsModel {
	
	
	private Connection connection;
    private String url = "jdbc:sqlserver://DESKTOP-R2MG0CS:1433;databaseName=University;integratedSecurity=true;encrypt=false";
	
	public studentsModel() throws SQLException {
		Connection connection = DriverManager.getConnection(url);
        System.out.println("Connection to SQL Server database successful!");
        
        Scanner scanner= new Scanner(System.in);
        
         
}
	
	
	
	public static void insertStudent(Connection connection, String name) throws SQLException {
        String insertQuery = "INSERT INTO student (student_name) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println("Student inserted successfully.");
        }
    }
	public static void viewStudents(Connection connection) throws SQLException {
        String selectQuery = "SELECT student_id, student_name  FROM student";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {
            System.out.println("Student Details:");
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String name = resultSet.getString("student_name");
                
                System.out.println("ID: " + id + ", Name: " + name );
            }
        }
    }
    public static void updateStudentName(Connection connection,int id, String newName) throws SQLException {
        String updateQuery = "UPDATE student SET student_name = ? WHERE student_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student name updated successfully.");
            } else {
                System.out.println("Student not found.");
            }
        }
    }

    public static void deleteStudent(Connection connection, int id) throws SQLException {
        String deleteQuery = "DELETE FROM student WHERE student_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully."); 
            } else {
                System.out.println("Student not found.");
            }
        }
    
}
	
	
	
	
	
	
	
}
