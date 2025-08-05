package db;

import java.sql.*;

public class Database {
    public boolean loginUser(String username, String password) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:users.db")) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            // Debug output
            System.out.println("Debug - Username parameter: '" + username + "'");
            System.out.println("Debug - Password parameter: '" + password + "'");
            System.out.println("Debug - Prepared query: " + query);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("Debug - Found user: " + rs.getString("username"));
                return true;
            } else {
                System.out.println("Debug - No matching user found");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Debug - SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
