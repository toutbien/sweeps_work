cat > src/db/Database.java << 'EOF'
package db;

import java.sql.*;

public class Database {
    private static final String DB_URL = "jdbc:sqlite:users.db";
    
    public static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            
            // Create users table
            String createTable = "CREATE TABLE IF NOT EXISTS users (" +
                               "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                               "username TEXT NOT NULL, " +
                               "password TEXT NOT NULL)";
            stmt.execute(createTable);
            
            // Insert sample data
            String insertAdmin = "INSERT OR IGNORE INTO users (username, password) VALUES ('admin', 'admin123')";
            String insertStudent = "INSERT OR IGNORE INTO users (username, password) VALUES ('student', 'securepass')";
            
            stmt.execute(insertAdmin);
            stmt.execute(insertStudent);
            
            System.out.println("Database initialized successfully.");
            
        } catch (SQLException e) {
            System.out.println("Database initialization failed: " + e.getMessage());
        }
    }
}
EOF
