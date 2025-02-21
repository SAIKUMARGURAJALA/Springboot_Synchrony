package dev.synchrony.user.user.exception.customException;

public class UserNameNotFoundException extends RuntimeException{
    public UserNameNotFoundException (String message){
        super(message);
    }
}
