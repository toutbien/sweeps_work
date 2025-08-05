package db;

import java.sql.*;

public class Database {
    public boolean loginUser(String username, String password) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:users.db")) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            return rs.next(); // returns true if user found
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
