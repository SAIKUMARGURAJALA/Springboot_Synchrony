package dev.synchrony.user.user.exception.customException;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException (String message){
        super(message);
    }

}
