package com.example.OnlineBankProcess.Controller;

import com.example.OnlineBankProcess.Entity.User;
import com.example.OnlineBankProcess.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody User user) {
        System.out.println("Received request: " + user);
        User savedUser = userService.registerUser(user);
        System.out.println("Saved user: " + savedUser);
        return ResponseEntity.ok(savedUser);
    }
}