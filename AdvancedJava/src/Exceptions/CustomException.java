package Exceptions;

public class CustomException extends Exception {
    public static final long serialVersionUID = 42L;

    @Override
    public String getMessage() {
        return "Custom exception!";
    }
}
