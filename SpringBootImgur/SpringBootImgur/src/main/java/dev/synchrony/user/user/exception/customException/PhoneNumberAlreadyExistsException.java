package dev.synchrony.user.user.exception.customException;

public class PhoneNumberAlreadyExistsException  extends RuntimeException {
    public PhoneNumberAlreadyExistsException (String message){
        super(message);
    }
}
