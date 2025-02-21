package dev.synchrony.user.user.controller;

import dev.synchrony.user.user.model.User;
import dev.synchrony.user.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired  // Constructor-based Dependency Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUserCredentials() {
        List<User> users;
        users = userService.findAllUserCredentials();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<Boolean> signup(@Valid @RequestBody User user) {
        boolean isRegistered;
        isRegistered = userService.registerUser(user);
        return new ResponseEntity<>(isRegistered, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> verifyLogin(
            @RequestParam String email,
            @RequestParam String password) {
        boolean isVerified;

        isVerified = userService.verifyLogin(email, password);

        return new ResponseEntity<>(isVerified, HttpStatus.OK);
    }




}
