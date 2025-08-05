
package ui;

import db.Database;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database db = new Database();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        boolean success = db.loginUser(username, password);

        if (success) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed.");
        }

        scanner.close();
    }
}
