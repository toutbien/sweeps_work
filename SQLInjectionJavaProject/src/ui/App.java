package ui;

import java.sql.*;
import java.util.Scanner;

public class App {
    private static final String DB_URL = "jdbc:sqlite:users.db";
    
    public static void main(String[] args) {
        System.out.println("=== SQL Injection Practice App ===");
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Login");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            
            String choice = scanner.nextLine();
            
            if (choice.equals("1")) {
                login(scanner);
            } else if (choice.equals("2")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        
        scanner.close();
    }
    
    private static void login(Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        // Vulnerable SQL query for practice purposes
        String sql = "SELECT * FROM users WHERE username = '" + username + 
                    "' AND password = '" + password + "'";
        
        System.out.println("Executing SQL: " + sql);
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                System.out.println("Login successful! Welcome, " + rs.getString("username"));
            } else {
                System.out.println("Login failed. Invalid credentials.");
            }
            
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}