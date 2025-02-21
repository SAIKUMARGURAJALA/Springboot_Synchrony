package dev.synchrony.user.user.service;

import dev.synchrony.user.user.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUserCredentials();
    boolean changePassword(String email, String currentPassword, String newPassword);
    boolean verifyLogin(String email, String password);
    boolean registerUser(User user);
}
