import java.util.Scanner;

public class LoginApp {
    public static void main(String[] args) {
        String predefinedUsername = "admin";
        String predefinedPassword = "1234";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (username.equals(predefinedUsername) && password.equals(predefinedPassword)) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Access Denied");
        }

        scanner.close();
    }
}