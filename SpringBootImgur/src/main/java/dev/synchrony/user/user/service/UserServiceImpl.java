package dev.synchrony.user.user.service;

import dev.synchrony.user.user.exception.customException.EmailAlreadyExistsException;
import dev.synchrony.user.user.exception.customException.InvalidPasswordException;
import dev.synchrony.user.user.exception.customException.PhoneNumberAlreadyExistsException;
import dev.synchrony.user.user.exception.customException.UserNameNotFoundException;
import dev.synchrony.user.user.model.User;
import dev.synchrony.user.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAllUserCredentials() {
        return userRepository.findAll();
    }

    @Override
    public boolean changePassword(String email, String currentPassword, String newPassword) {
        return false;
    }

    @Override
    public boolean verifyLogin(String userName, String password) {
        User user;
        try {
            userName = userName.toLowerCase(Locale.ROOT);
            user = userRepository.findByUserName(userName)
                    .orElseThrow(() -> new UserNameNotFoundException("User with this userName/ email does not exist"));

            if (passwordEncoder.matches(password, user.getPassword()))
                return true;
            else
                throw new InvalidPasswordException("Invalid Password");
        }
        catch (Exception e)
        {
            System.err.println("Error saving user: " + e.getMessage());
            return false;  // Returning false if save failed
        }

    }

    public boolean registerUser(User user) {
        String userName, phoneNumber;
//        boolean isUserNameAlreadyExists=
        try
        {
            userName= user.getUserName().toLowerCase(Locale.ROOT);
            user.setUserName(userName);
            if (userRepository.findByUserName(user.getUserName()).isPresent()) {
                throw new EmailAlreadyExistsException("Email is already registered");
            }

            phoneNumber= user.getPhoneNumber();
            if((userRepository.findByPhoneNumber(phoneNumber)).isPresent()){
            throw new PhoneNumberAlreadyExistsException("Phone number is already registered");
        }
            // Encode the password before saving
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            // Save the user in the database
            User savedUser = userRepository.save(user);
            // Check if the saved user is not null and has a valid ObjectId (to ensure it's saved)
            return savedUser.getId() != null;
        }
        catch (Exception e) {
            System.err.println("Error saving user: " + e.getMessage());
            return false;  // Returning false if save failed
        }
    }
}
