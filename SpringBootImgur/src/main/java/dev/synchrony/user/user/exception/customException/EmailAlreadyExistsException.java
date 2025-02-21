package dev.synchrony.user.user.exception.customException;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException (String message){
        super(message);
    }
}
