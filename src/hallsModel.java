import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class hallsModel {
	private Connection connection;
    private String url = "jdbc:sqlserver://DESKTOP-R2MG0CS:1433;databaseName=University;integratedSecurity=true;encrypt=false";
    
    public hallsModel() throws SQLException {
    	 Connection connection = DriverManager.getConnection(url);
         System.out.println("Connection to SQL Server database successful!");
         Scanner scanner= new Scanner(System.in);
         
         
}


    public static void insertHall(Connection connection, String name) throws SQLException {
        String insertQuery = "INSERT INTO hall (hall_name) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, name);
            
            preparedStatement.executeUpdate();
            System.out.println("hall inserted successfully.");
        }
    }
    public static void viewHalls(Connection connection) throws SQLException {
        String selectQuery = "SELECT hall_id, hall_name  FROM hall";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {
            System.out.println("Hall Details:");
            while (resultSet.next()) {
                int id = resultSet.getInt("hall_id");
                String name = resultSet.getString("hall_name");
                
                System.out.println("ID: " + id + ", Name: " + name );
            }
        }
    }
    public static void updateHallName(Connection connection,int id, String newName) throws SQLException {
        String updateQuery = "UPDATE hall SET hall_name = ? WHERE hall_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Hall name updated successfully.");
            } else {
                System.out.println("Hall not found.");
            }
        }
    }
    public static void deleteHall(Connection connection, int id) throws SQLException {
        String deleteQuery = "DELETE FROM hall WHERE hall_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Hall deleted successfully."); 
            } else {
                System.out.println("Hall not found.");
            }
        }
    
   }
    
    
}