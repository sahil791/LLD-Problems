package Prototype;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirlineReservation {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Open a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
            if (connection != null) {
                System.out.println("Successfully connected to the database!");
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed! Check output console");
            e.printStackTrace();
        }
        
        return connection;
    }
    
    // Example usage
    public static void reserve(String name) {
        Connection connection = getConnection();
        PreparedStatement selectStmt = null;
        PreparedStatement updateStmt = null;
        
        try {
            if (connection != null) {
                connection.setAutoCommit(false);  // Start transaction
                
                // Find first available seat
                String selectQuery = "SELECT seat_id, seat_number FROM airline.seats WHERE user_id IS NULL ORDER BY seat_number LIMIT 1 FOR UPDATE SKIP LOCKED";
                selectStmt = connection.prepareStatement(selectQuery);
                ResultSet rs = selectStmt.executeQuery();
                
                if (rs.next()) {
                    int seatId = rs.getInt("seat_id");
                    String seatNumber = rs.getString("seat_number");
                    
                    // Update the seat with user name
                    String updateQuery = "UPDATE airline.seats SET user_id = ?, user = ? WHERE seat_id = ?";
                    updateStmt = connection.prepareStatement(updateQuery);
                    updateStmt.setInt(1, name.hashCode());  // Using hashCode as a simple user_id
                    updateStmt.setString(2, name);  // Using name as a simple user
                    updateStmt.setInt(3, seatId);
                    
                    int rowsAffected = updateStmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.printf("Successfully reserved seat %s for %s%n", seatNumber, name);
                        connection.commit();  // Commit transaction
                    } else {
                        System.out.printf("Failed to reserve seat for %s - seat was taken%n", name);
                        connection.rollback();  // Rollback if update failed
                    }
                } else {
                    System.out.println("No seats available!");
                    connection.rollback();
                }
                
            }
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();  // Rollback on error
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Error during reservation: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (selectStmt != null) selectStmt.close();
                if (updateStmt != null) updateStmt.close();
                if (connection != null) {
                    connection.setAutoCommit(true);  // Reset auto-commit
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        List<String> names = FileReader.readNames();
//        names.forEach(AirlineReservation::reserve);
        List<Thread> threads = new ArrayList<>();
        for(String name : names) {
            threads.add(new Thread(() -> reserve(name)));
        }
        for(Thread thread: threads) {
            thread.start();
        }
        for(Thread thread: threads) {
            thread.join();
        }
        System.out.println(names);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

/***
 *
 * CREATE TABLE seats (
 *     seat_id INT PRIMARY KEY AUTO_INCREMENT,
 *     user_id INT,
 *     seat_number VARCHAR(4) NOT NULL,
 *     UNIQUE (seat_number)
 * );
 * 10 millis - simple loop
 * 1457 - multi
 * 1233 - with skip locked
 *
 *
 */