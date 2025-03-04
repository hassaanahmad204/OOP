package main;

import java.io.Console;
import banking.BankingSystem;


public class BankApplication {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("No console is available!");
            return;
        }
        
        System.out.print("Enter the account number: ");
        String accountNumber = console.readLine();
        System.out.print("Enter the PIN: ");
        char[] arrayPin = console.readPassword();
        String pin = new String(arrayPin);
        
        boolean isAuthenticated = BankingSystem.authenticate(accountNumber, pin);
        if (isAuthenticated) {
            System.out.println("Access granted to your account.");
        } else {
            System.out.println("Access denied due to incorrect credentials!");
        }
    }
}
