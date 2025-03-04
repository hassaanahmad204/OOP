package banking;

import util.PinValidator;

public class BankingSystem {
    private static final String storedAccountNumber = "69420";
    private static final String storedPin = "9110";

    public static boolean authenticate(String accountNumber, String pin) {
        if (!storedAccountNumber.equals(accountNumber)) {
            return false;
        }
        
        LoginProcessor login = new LoginProcessor();
        return login.pinVerification(pin);
    }
    
    static class LoginProcessor {
        public boolean pinVerification(String pin) {
            return storedPin.equals(pin);
        }
    }
}
