import java.util.Scanner;

public class UserInfo {
    private String username = "testusername";
    private String password = "testpassword12345";

    private boolean checkCredentials(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		
        System.out.print("Enter Username: ");
        String inputUsername = scanner.nextLine();
        
        System.out.print("Enter Password: ");
        String inputPassword = scanner.nextLine();
        
        UserInfo info = new UserInfo();
        
        if (info.checkCredentials(inputUsername, inputPassword)) {
            System.out.println("Login Successful!");
            System.out.println("Username: " + info.username);
            System.out.println("Password: " + info.password);
        } else {
            System.out.println("Login Failed! Username or Password is incorrect.");
        }

        scanner.close();
    }
}
