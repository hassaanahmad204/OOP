package util;

public class PinValidator {
    public static class Rules {
        public boolean isValid(String pin) {
            return pin.length() == 4 && pin.matches("\\d+");
        }
    }
}
